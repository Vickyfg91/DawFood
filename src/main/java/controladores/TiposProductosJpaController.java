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
import entidades.Productos;
import entidades.TiposProductos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author vickyfg
 */
public class TiposProductosJpaController implements Serializable {

    public TiposProductosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TiposProductos tiposProductos) throws PreexistingEntityException, Exception {
        if (tiposProductos.getProductosCollection() == null) {
            tiposProductos.setProductosCollection(new ArrayList<Productos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Productos> attachedProductosCollection = new ArrayList<Productos>();
            for (Productos productosCollectionProductosToAttach : tiposProductos.getProductosCollection()) {
                productosCollectionProductosToAttach = em.getReference(productosCollectionProductosToAttach.getClass(), productosCollectionProductosToAttach.getIdProducto());
                attachedProductosCollection.add(productosCollectionProductosToAttach);
            }
            tiposProductos.setProductosCollection(attachedProductosCollection);
            em.persist(tiposProductos);
            for (Productos productosCollectionProductos : tiposProductos.getProductosCollection()) {
                TiposProductos oldIdTipoOfProductosCollectionProductos = productosCollectionProductos.getIdTipo();
                productosCollectionProductos.setIdTipo(tiposProductos);
                productosCollectionProductos = em.merge(productosCollectionProductos);
                if (oldIdTipoOfProductosCollectionProductos != null) {
                    oldIdTipoOfProductosCollectionProductos.getProductosCollection().remove(productosCollectionProductos);
                    oldIdTipoOfProductosCollectionProductos = em.merge(oldIdTipoOfProductosCollectionProductos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTiposProductos(tiposProductos.getIdTipo()) != null) {
                throw new PreexistingEntityException("TiposProductos " + tiposProductos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TiposProductos tiposProductos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TiposProductos persistentTiposProductos = em.find(TiposProductos.class, tiposProductos.getIdTipo());
            Collection<Productos> productosCollectionOld = persistentTiposProductos.getProductosCollection();
            Collection<Productos> productosCollectionNew = tiposProductos.getProductosCollection();
            List<String> illegalOrphanMessages = null;
            for (Productos productosCollectionOldProductos : productosCollectionOld) {
                if (!productosCollectionNew.contains(productosCollectionOldProductos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Productos " + productosCollectionOldProductos + " since its idTipo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Productos> attachedProductosCollectionNew = new ArrayList<Productos>();
            for (Productos productosCollectionNewProductosToAttach : productosCollectionNew) {
                productosCollectionNewProductosToAttach = em.getReference(productosCollectionNewProductosToAttach.getClass(), productosCollectionNewProductosToAttach.getIdProducto());
                attachedProductosCollectionNew.add(productosCollectionNewProductosToAttach);
            }
            productosCollectionNew = attachedProductosCollectionNew;
            tiposProductos.setProductosCollection(productosCollectionNew);
            tiposProductos = em.merge(tiposProductos);
            for (Productos productosCollectionNewProductos : productosCollectionNew) {
                if (!productosCollectionOld.contains(productosCollectionNewProductos)) {
                    TiposProductos oldIdTipoOfProductosCollectionNewProductos = productosCollectionNewProductos.getIdTipo();
                    productosCollectionNewProductos.setIdTipo(tiposProductos);
                    productosCollectionNewProductos = em.merge(productosCollectionNewProductos);
                    if (oldIdTipoOfProductosCollectionNewProductos != null && !oldIdTipoOfProductosCollectionNewProductos.equals(tiposProductos)) {
                        oldIdTipoOfProductosCollectionNewProductos.getProductosCollection().remove(productosCollectionNewProductos);
                        oldIdTipoOfProductosCollectionNewProductos = em.merge(oldIdTipoOfProductosCollectionNewProductos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tiposProductos.getIdTipo();
                if (findTiposProductos(id) == null) {
                    throw new NonexistentEntityException("The tiposProductos with id " + id + " no longer exists.");
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
            TiposProductos tiposProductos;
            try {
                tiposProductos = em.getReference(TiposProductos.class, id);
                tiposProductos.getIdTipo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiposProductos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Productos> productosCollectionOrphanCheck = tiposProductos.getProductosCollection();
            for (Productos productosCollectionOrphanCheckProductos : productosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TiposProductos (" + tiposProductos + ") cannot be destroyed since the Productos " + productosCollectionOrphanCheckProductos + " in its productosCollection field has a non-nullable idTipo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tiposProductos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TiposProductos> findTiposProductosEntities() {
        return findTiposProductosEntities(true, -1, -1);
    }

    public List<TiposProductos> findTiposProductosEntities(int maxResults, int firstResult) {
        return findTiposProductosEntities(false, maxResults, firstResult);
    }

    private List<TiposProductos> findTiposProductosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TiposProductos.class));
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

    public TiposProductos findTiposProductos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TiposProductos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiposProductosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TiposProductos> rt = cq.from(TiposProductos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
