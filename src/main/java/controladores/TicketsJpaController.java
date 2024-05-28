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
import entidades.Tpv;
import entidades.DetalleTicket;
import entidades.Tickets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author vickyfg
 */
public class TicketsJpaController implements Serializable {

    public TicketsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tickets tickets) {
        if (tickets.getDetalleTicketCollection() == null) {
            tickets.setDetalleTicketCollection(new ArrayList<DetalleTicket>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tpv idTpv = tickets.getIdTpv();
            if (idTpv != null) {
                idTpv = em.getReference(idTpv.getClass(), idTpv.getIdTpv());
                tickets.setIdTpv(idTpv);
            }
            Collection<DetalleTicket> attachedDetalleTicketCollection = new ArrayList<DetalleTicket>();
            for (DetalleTicket detalleTicketCollectionDetalleTicketToAttach : tickets.getDetalleTicketCollection()) {
                detalleTicketCollectionDetalleTicketToAttach = em.getReference(detalleTicketCollectionDetalleTicketToAttach.getClass(), detalleTicketCollectionDetalleTicketToAttach.getDetalleTicketPK());
                attachedDetalleTicketCollection.add(detalleTicketCollectionDetalleTicketToAttach);
            }
            tickets.setDetalleTicketCollection(attachedDetalleTicketCollection);
            em.persist(tickets);
            if (idTpv != null) {
                idTpv.getTicketsCollection().add(tickets);
                idTpv = em.merge(idTpv);
            }
            for (DetalleTicket detalleTicketCollectionDetalleTicket : tickets.getDetalleTicketCollection()) {
                Tickets oldTicketsOfDetalleTicketCollectionDetalleTicket = detalleTicketCollectionDetalleTicket.getTickets();
                detalleTicketCollectionDetalleTicket.setTickets(tickets);
                detalleTicketCollectionDetalleTicket = em.merge(detalleTicketCollectionDetalleTicket);
                if (oldTicketsOfDetalleTicketCollectionDetalleTicket != null) {
                    oldTicketsOfDetalleTicketCollectionDetalleTicket.getDetalleTicketCollection().remove(detalleTicketCollectionDetalleTicket);
                    oldTicketsOfDetalleTicketCollectionDetalleTicket = em.merge(oldTicketsOfDetalleTicketCollectionDetalleTicket);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tickets tickets) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tickets persistentTickets = em.find(Tickets.class, tickets.getIdTicket());
            Tpv idTpvOld = persistentTickets.getIdTpv();
            Tpv idTpvNew = tickets.getIdTpv();
            Collection<DetalleTicket> detalleTicketCollectionOld = persistentTickets.getDetalleTicketCollection();
            Collection<DetalleTicket> detalleTicketCollectionNew = tickets.getDetalleTicketCollection();
            List<String> illegalOrphanMessages = null;
            for (DetalleTicket detalleTicketCollectionOldDetalleTicket : detalleTicketCollectionOld) {
                if (!detalleTicketCollectionNew.contains(detalleTicketCollectionOldDetalleTicket)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleTicket " + detalleTicketCollectionOldDetalleTicket + " since its tickets field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idTpvNew != null) {
                idTpvNew = em.getReference(idTpvNew.getClass(), idTpvNew.getIdTpv());
                tickets.setIdTpv(idTpvNew);
            }
            Collection<DetalleTicket> attachedDetalleTicketCollectionNew = new ArrayList<DetalleTicket>();
            for (DetalleTicket detalleTicketCollectionNewDetalleTicketToAttach : detalleTicketCollectionNew) {
                detalleTicketCollectionNewDetalleTicketToAttach = em.getReference(detalleTicketCollectionNewDetalleTicketToAttach.getClass(), detalleTicketCollectionNewDetalleTicketToAttach.getDetalleTicketPK());
                attachedDetalleTicketCollectionNew.add(detalleTicketCollectionNewDetalleTicketToAttach);
            }
            detalleTicketCollectionNew = attachedDetalleTicketCollectionNew;
            tickets.setDetalleTicketCollection(detalleTicketCollectionNew);
            tickets = em.merge(tickets);
            if (idTpvOld != null && !idTpvOld.equals(idTpvNew)) {
                idTpvOld.getTicketsCollection().remove(tickets);
                idTpvOld = em.merge(idTpvOld);
            }
            if (idTpvNew != null && !idTpvNew.equals(idTpvOld)) {
                idTpvNew.getTicketsCollection().add(tickets);
                idTpvNew = em.merge(idTpvNew);
            }
            for (DetalleTicket detalleTicketCollectionNewDetalleTicket : detalleTicketCollectionNew) {
                if (!detalleTicketCollectionOld.contains(detalleTicketCollectionNewDetalleTicket)) {
                    Tickets oldTicketsOfDetalleTicketCollectionNewDetalleTicket = detalleTicketCollectionNewDetalleTicket.getTickets();
                    detalleTicketCollectionNewDetalleTicket.setTickets(tickets);
                    detalleTicketCollectionNewDetalleTicket = em.merge(detalleTicketCollectionNewDetalleTicket);
                    if (oldTicketsOfDetalleTicketCollectionNewDetalleTicket != null && !oldTicketsOfDetalleTicketCollectionNewDetalleTicket.equals(tickets)) {
                        oldTicketsOfDetalleTicketCollectionNewDetalleTicket.getDetalleTicketCollection().remove(detalleTicketCollectionNewDetalleTicket);
                        oldTicketsOfDetalleTicketCollectionNewDetalleTicket = em.merge(oldTicketsOfDetalleTicketCollectionNewDetalleTicket);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tickets.getIdTicket();
                if (findTickets(id) == null) {
                    throw new NonexistentEntityException("The tickets with id " + id + " no longer exists.");
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
            Tickets tickets;
            try {
                tickets = em.getReference(Tickets.class, id);
                tickets.getIdTicket();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tickets with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DetalleTicket> detalleTicketCollectionOrphanCheck = tickets.getDetalleTicketCollection();
            for (DetalleTicket detalleTicketCollectionOrphanCheckDetalleTicket : detalleTicketCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tickets (" + tickets + ") cannot be destroyed since the DetalleTicket " + detalleTicketCollectionOrphanCheckDetalleTicket + " in its detalleTicketCollection field has a non-nullable tickets field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Tpv idTpv = tickets.getIdTpv();
            if (idTpv != null) {
                idTpv.getTicketsCollection().remove(tickets);
                idTpv = em.merge(idTpv);
            }
            em.remove(tickets);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tickets> findTicketsEntities() {
        return findTicketsEntities(true, -1, -1);
    }

    public List<Tickets> findTicketsEntities(int maxResults, int firstResult) {
        return findTicketsEntities(false, maxResults, firstResult);
    }

    private List<Tickets> findTicketsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tickets.class));
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

    public Tickets findTickets(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tickets.class, id);
        } finally {
            em.close();
        }
    }

    public int getTicketsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tickets> rt = cq.from(Tickets.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
