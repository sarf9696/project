package ir.fanap.mehdisarfejoo.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ParentDAO<E> {

    protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mehdifinalproject");

    public ParentDAO() {
    }

    public E create(E entity) {

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(entity);

        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();

        entityManager.close();

        return entity;
    }

    public E update(E entity) {

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        E theEntity = entityManager.merge(entity);

        entityManager.getTransaction().commit();

        entityManager.close();

        return theEntity;
    }

    public E find(Class<E> type, Object id) {

        EntityManager entityManager = factory.createEntityManager();

        E entity = entityManager.find(type, id);

        if (entity != null)
            entityManager.refresh(entity);

        entityManager.close();

        return entity;
    }

    public void delete(Class type, Object id) {

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Object theEntity = entityManager.getReference(type, id); // Vs. entityManager.find()

        entityManager.remove(theEntity);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<E> findWithNamedQuery(String queryName, String parameterName, Object parameterValue) {

        EntityManager entityManager = factory.createEntityManager();

        Query query = entityManager.createNamedQuery(queryName);

        query.setParameter(parameterName, parameterValue);

        List result = query.getResultList();

        entityManager.close();

        return result;
    }

    public List<E> findWithNamedQuery(String queryName) {

        EntityManager entityManager = factory.createEntityManager();

        Query query = entityManager.createNamedQuery(queryName);

        List result = query.getResultList();

        entityManager.close();

        return result;
    }

    public long countWithNamedQuery(String queryName) {

        EntityManager entityManager = factory.createEntityManager();

        Query query = entityManager.createNamedQuery(queryName);

        long result = (long) query.getSingleResult();

        entityManager.close();

        return result;
    }

    public void closeFactory() {

        if (factory != null)
            factory.close();
    }
}
