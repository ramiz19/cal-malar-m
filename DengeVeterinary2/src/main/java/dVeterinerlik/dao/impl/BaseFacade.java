package dVeterinerlik.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

public abstract class BaseFacade<T> {

    private final Class<T> entityClass;

    public BaseFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(unitName = "com.dengedecfa_DengeVeterinary2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(rt);
        cq.orderBy(cb.desc(rt.get("id")));
        Query q = getEntityManager().createQuery(cq);
        return q.getResultList();
    }

    public List<T> findRange(int[] range) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(rt);
        cq.orderBy(cb.desc(rt.get("id")));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public List<T> search(int[] range, String field, String term) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(rt);

        if (field != null) {
            Path<String> f = rt.get(field);
            cq.where(cb.like(cb.lower(f), "%" + term + "%"));
        }
        cq.orderBy(cb.desc(rt.get("id")));
        Query q = getEntityManager().createQuery(cq);

        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int searchCount(String field, String term) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        if (field != null) {
            Path<String> f = rt.get(field);
            cq.where(cb.like(cb.lower(f), "%" + term + "%"));
        }
        Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public int count() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public T findByField(String field, String value) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<T> c = cq.from(entityClass);
        cq.select(c);
        cq.where(cb.equal(c.get(field), value));
        Query q = getEntityManager().createQuery(cq);
        return (T) q.getSingleResult();
    }
}
