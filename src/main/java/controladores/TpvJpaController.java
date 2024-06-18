/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Tickets;
import entidades.Tpv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Victoria
 */
public class TpvJpaController implements Serializable {

    public TpvJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tpv tpv) {
        if (tpv.getTicketsCollection() == null) {
            tpv.setTicketsCollection(new ArrayList<Tickets>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Tickets> attachedTicketsCollection = new ArrayList<Tickets>();
            for (Tickets ticketsCollectionTicketsToAttach : tpv.getTicketsCollection()) {
                ticketsCollectionTicketsToAttach = em.getReference(ticketsCollectionTicketsToAttach.getClass(), ticketsCollectionTicketsToAttach.getIdTicket());
                attachedTicketsCollection.add(ticketsCollectionTicketsToAttach);
            }
            tpv.setTicketsCollection(attachedTicketsCollection);
            em.persist(tpv);
            for (Tickets ticketsCollectionTickets : tpv.getTicketsCollection()) {
                Tpv oldIdTpvOfTicketsCollectionTickets = ticketsCollectionTickets.getIdTpv();
                ticketsCollectionTickets.setIdTpv(tpv);
                ticketsCollectionTickets = em.merge(ticketsCollectionTickets);
                if (oldIdTpvOfTicketsCollectionTickets != null) {
                    oldIdTpvOfTicketsCollectionTickets.getTicketsCollection().remove(ticketsCollectionTickets);
                    oldIdTpvOfTicketsCollectionTickets = em.merge(oldIdTpvOfTicketsCollectionTickets);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tpv tpv) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tpv persistentTpv = em.find(Tpv.class, tpv.getIdTpv());
            Collection<Tickets> ticketsCollectionOld = persistentTpv.getTicketsCollection();
            Collection<Tickets> ticketsCollectionNew = tpv.getTicketsCollection();
            List<String> illegalOrphanMessages = null;
            for (Tickets ticketsCollectionOldTickets : ticketsCollectionOld) {
                if (!ticketsCollectionNew.contains(ticketsCollectionOldTickets)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tickets " + ticketsCollectionOldTickets + " since its idTpv field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Tickets> attachedTicketsCollectionNew = new ArrayList<Tickets>();
            for (Tickets ticketsCollectionNewTicketsToAttach : ticketsCollectionNew) {
                ticketsCollectionNewTicketsToAttach = em.getReference(ticketsCollectionNewTicketsToAttach.getClass(), ticketsCollectionNewTicketsToAttach.getIdTicket());
                attachedTicketsCollectionNew.add(ticketsCollectionNewTicketsToAttach);
            }
            ticketsCollectionNew = attachedTicketsCollectionNew;
            tpv.setTicketsCollection(ticketsCollectionNew);
            tpv = em.merge(tpv);
            for (Tickets ticketsCollectionNewTickets : ticketsCollectionNew) {
                if (!ticketsCollectionOld.contains(ticketsCollectionNewTickets)) {
                    Tpv oldIdTpvOfTicketsCollectionNewTickets = ticketsCollectionNewTickets.getIdTpv();
                    ticketsCollectionNewTickets.setIdTpv(tpv);
                    ticketsCollectionNewTickets = em.merge(ticketsCollectionNewTickets);
                    if (oldIdTpvOfTicketsCollectionNewTickets != null && !oldIdTpvOfTicketsCollectionNewTickets.equals(tpv)) {
                        oldIdTpvOfTicketsCollectionNewTickets.getTicketsCollection().remove(ticketsCollectionNewTickets);
                        oldIdTpvOfTicketsCollectionNewTickets = em.merge(oldIdTpvOfTicketsCollectionNewTickets);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tpv.getIdTpv();
                if (findTpv(id) == null) {
                    throw new NonexistentEntityException("The tpv with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tpv tpv;
            try {
                tpv = em.getReference(Tpv.class, id);
                tpv.getIdTpv();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tpv with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Tickets> ticketsCollectionOrphanCheck = tpv.getTicketsCollection();
            for (Tickets ticketsCollectionOrphanCheckTickets : ticketsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tpv (" + tpv + ") cannot be destroyed since the Tickets " + ticketsCollectionOrphanCheckTickets + " in its ticketsCollection field has a non-nullable idTpv field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tpv);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tpv> findTpvEntities() {
        return findTpvEntities(true, -1, -1);
    }

    public List<Tpv> findTpvEntities(int maxResults, int firstResult) {
        return findTpvEntities(false, maxResults, firstResult);
    }

    private List<Tpv> findTpvEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tpv.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tpv findTpv(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tpv.class, id);
        } finally {
            em.close();
        }
    }

    public int getTpvCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tpv> rt = cq.from(Tpv.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
