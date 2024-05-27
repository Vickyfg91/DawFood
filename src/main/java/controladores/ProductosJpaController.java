/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.TiposProductos;
import entidades.DetalleTicket;
import entidades.Productos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author vickyfg
 */

// Proporciona métodos para realizar operaciones CRUD y consultas adicionales.

public class ProductosJpaController implements Serializable {

    public ProductosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método que recibe un producto y lo crea en la base de datos 
    public void create(Productos productos) throws PreexistingEntityException, Exception {
        if (productos.getDetalleTicketCollection() == null) {
            productos.setDetalleTicketCollection(new ArrayList<DetalleTicket>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            //Controla y maneja que tipo de producto esta añadiendo
            
            TiposProductos idTipo = productos.getIdTipo();
            if (idTipo != null) {
                idTipo = em.getReference(idTipo.getClass(), idTipo.getIdTipo());
                productos.setIdTipo(idTipo);
            }
            
            // COntrola la relación con DetalleTicket
            Collection<DetalleTicket> attachedDetalleTicketCollection = new ArrayList<DetalleTicket>();
            for (DetalleTicket detalleTicketCollectionDetalleTicketToAttach : productos.getDetalleTicketCollection()) {
                detalleTicketCollectionDetalleTicketToAttach = em.getReference(detalleTicketCollectionDetalleTicketToAttach.getClass(), detalleTicketCollectionDetalleTicketToAttach.getDetalleTicketPK());
                attachedDetalleTicketCollection.add(detalleTicketCollectionDetalleTicketToAttach);
            }
            productos.setDetalleTicketCollection(attachedDetalleTicketCollection);
            em.persist(productos);
            if (idTipo != null) {
                idTipo.getProductosCollection().add(productos);
                idTipo = em.merge(idTipo);
            }
            for (DetalleTicket detalleTicketCollectionDetalleTicket : productos.getDetalleTicketCollection()) {
                Productos oldProductosOfDetalleTicketCollectionDetalleTicket = detalleTicketCollectionDetalleTicket.getProductos();
                detalleTicketCollectionDetalleTicket.setProductos(productos);
                detalleTicketCollectionDetalleTicket = em.merge(detalleTicketCollectionDetalleTicket);
                if (oldProductosOfDetalleTicketCollectionDetalleTicket != null) {
                    oldProductosOfDetalleTicketCollectionDetalleTicket.getDetalleTicketCollection().remove(detalleTicketCollectionDetalleTicket);
                    oldProductosOfDetalleTicketCollectionDetalleTicket = em.merge(oldProductosOfDetalleTicketCollectionDetalleTicket);
                }
            }
            em.getTransaction().commit();
            
            //COntrola que no exita y se duplique 
        } catch (Exception ex) {
            if (findProductos(productos.getIdProducto()) != null) {
                throw new PreexistingEntityException("Producto " + productos + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    //Método que recibe un producto y lo edita en la base de datos
    public void edit(Productos productos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productos persistentProductos = em.find(Productos.class, productos.getIdProducto());
            
            //Controla las relaciones con el tipo producto y el detalle ticket
            
            TiposProductos idTipoOld = persistentProductos.getIdTipo();
            TiposProductos idTipoNew = productos.getIdTipo();
            Collection<DetalleTicket> detalleTicketCollectionOld = persistentProductos.getDetalleTicketCollection();
            Collection<DetalleTicket> detalleTicketCollectionNew = productos.getDetalleTicketCollection();
            List<String> illegalOrphanMessages = null;
            for (DetalleTicket detalleTicketCollectionOldDetalleTicket : detalleTicketCollectionOld) {
                if (!detalleTicketCollectionNew.contains(detalleTicketCollectionOldDetalleTicket)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }

                    illegalOrphanMessages.add("Debes conservar DetalleTicket " + detalleTicketCollectionOldDetalleTicket + " ya que su campo productos no puede ser nulo.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idTipoNew != null) {
                idTipoNew = em.getReference(idTipoNew.getClass(), idTipoNew.getIdTipo());
                productos.setIdTipo(idTipoNew);
            }
            Collection<DetalleTicket> attachedDetalleTicketCollectionNew = new ArrayList<DetalleTicket>();
            for (DetalleTicket detalleTicketCollectionNewDetalleTicketToAttach : detalleTicketCollectionNew) {
                detalleTicketCollectionNewDetalleTicketToAttach = em.getReference(detalleTicketCollectionNewDetalleTicketToAttach.getClass(), detalleTicketCollectionNewDetalleTicketToAttach.getDetalleTicketPK());
                attachedDetalleTicketCollectionNew.add(detalleTicketCollectionNewDetalleTicketToAttach);
            }
            detalleTicketCollectionNew = attachedDetalleTicketCollectionNew;
            productos.setDetalleTicketCollection(detalleTicketCollectionNew);
            productos = em.merge(productos);
            if (idTipoOld != null && !idTipoOld.equals(idTipoNew)) {
                idTipoOld.getProductosCollection().remove(productos);
                idTipoOld = em.merge(idTipoOld);
            }
            if (idTipoNew != null && !idTipoNew.equals(idTipoOld)) {
                idTipoNew.getProductosCollection().add(productos);
                idTipoNew = em.merge(idTipoNew);
            }
            for (DetalleTicket detalleTicketCollectionNewDetalleTicket : detalleTicketCollectionNew) {
                if (!detalleTicketCollectionOld.contains(detalleTicketCollectionNewDetalleTicket)) {
                    Productos oldProductosOfDetalleTicketCollectionNewDetalleTicket = detalleTicketCollectionNewDetalleTicket.getProductos();
                    detalleTicketCollectionNewDetalleTicket.setProductos(productos);
                    detalleTicketCollectionNewDetalleTicket = em.merge(detalleTicketCollectionNewDetalleTicket);
                    if (oldProductosOfDetalleTicketCollectionNewDetalleTicket != null && !oldProductosOfDetalleTicketCollectionNewDetalleTicket.equals(productos)) {
                        oldProductosOfDetalleTicketCollectionNewDetalleTicket.getDetalleTicketCollection().remove(detalleTicketCollectionNewDetalleTicket);
                        oldProductosOfDetalleTicketCollectionNewDetalleTicket = em.merge(oldProductosOfDetalleTicketCollectionNewDetalleTicket);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productos.getIdProducto();
                if (findProductos(id) == null) {
                    throw new NonexistentEntityException("The productos with id " + id + " no longer exists.");
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
            Productos productos;
            try {
                productos = em.getReference(Productos.class, id);
                productos.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DetalleTicket> detalleTicketCollectionOrphanCheck = productos.getDetalleTicketCollection();
            for (DetalleTicket detalleTicketCollectionOrphanCheckDetalleTicket : detalleTicketCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Productos (" + productos + ") cannot be destroyed since the DetalleTicket " + detalleTicketCollectionOrphanCheckDetalleTicket + " in its detalleTicketCollection field has a non-nullable productos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            TiposProductos idTipo = productos.getIdTipo();
            if (idTipo != null) {
                idTipo.getProductosCollection().remove(productos);
                idTipo = em.merge(idTipo);
            }
            em.remove(productos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productos> findProductosEntities() {
        return findProductosEntities(true, -1, -1);
    }

    public List<Productos> findProductosEntities(int maxResults, int firstResult) {
        return findProductosEntities(false, maxResults, firstResult);
    }

    private List<Productos> findProductosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productos.class));
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

    public Productos findProductos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productos.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productos> rt = cq.from(Productos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    // Método añadido, usando una named query de la entidad producto
    public Productos findByTipo(String tipo){
        EntityManager em = getEntityManager();
        // Se crea la query usando el nombre de la named query
        Query q = em.createNamedQuery("Productos.findByTipo");
        // Se establece el parámetro de la consulta
        q.setParameter("tipo", tipo);
        return (Productos)q.getSingleResult();
    }
    
}
