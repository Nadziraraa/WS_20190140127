/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.c.mahasiswa7.tugas.assesment;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ws.c.mahasiswa7.tugas.assesment.exceptions.NonexistentEntityException;
import ws.c.mahasiswa7.tugas.assesment.exceptions.PreexistingEntityException;

/**
 *
 * @author asus
 */
public class DatamahasiswatiJpaController implements Serializable {

    public DatamahasiswatiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ws.c.mahasiswa.127_tugas.assesment_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DatamahasiswatiJpaController() {
    }
    
    

    public void create(Datamahasiswati datamahasiswati) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(datamahasiswati);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDatamahasiswati(datamahasiswati.getNim()) != null) {
                throw new PreexistingEntityException("Datamahasiswati " + datamahasiswati + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Datamahasiswati datamahasiswati) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            datamahasiswati = em.merge(datamahasiswati);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = datamahasiswati.getNim();
                if (findDatamahasiswati(id) == null) {
                    throw new NonexistentEntityException("The datamahasiswati with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Datamahasiswati datamahasiswati;
            try {
                datamahasiswati = em.getReference(Datamahasiswati.class, id);
                datamahasiswati.getNim();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The datamahasiswati with id " + id + " no longer exists.", enfe);
            }
            em.remove(datamahasiswati);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Datamahasiswati> findDatamahasiswatiEntities() {
        return findDatamahasiswatiEntities(true, -1, -1);
    }

    public List<Datamahasiswati> findDatamahasiswatiEntities(int maxResults, int firstResult) {
        return findDatamahasiswatiEntities(false, maxResults, firstResult);
    }

    private List<Datamahasiswati> findDatamahasiswatiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Datamahasiswati.class));
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

    public Datamahasiswati findDatamahasiswati(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Datamahasiswati.class, id);
        } finally {
            em.close();
        }
    }

    public int getDatamahasiswatiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Datamahasiswati> rt = cq.from(Datamahasiswati.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
