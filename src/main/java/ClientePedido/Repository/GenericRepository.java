package ClientePedido.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GenericRepository<T> {

    private EntityManager em;

    // Injeção de dependência manual
    public GenericRepository(EntityManager em) {
        this.em = em;
    }

    public GenericRepository() {
    }

    // save
    public void save(T obj) {
        em.persist(obj);
    }

    // Delete
    public void delete(T obj) {
        em.merge(obj);
        em.remove(obj);
    }

    // FindById
    public T findById(Class<T> clazz, Long id) {
        return em.find(clazz,id);
    }

    // FindAll
    public List<T> findAll(Class<T> clazz) {
        String jpql = "SELECT e FROM " + clazz.getSimpleName() + " e";
        TypedQuery<T> query = em.createQuery(jpql, clazz);
        return query.getResultList();
    }
}
