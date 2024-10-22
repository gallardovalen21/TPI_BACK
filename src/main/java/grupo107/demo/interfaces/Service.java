package grupo107.demo.interfaces;

import grupo107.demo.entities.Prueba;

import java.util.List;

public interface Service<T,K> {
    Prueba create(T entity);

    void update(T entity);

    T delete(K id);

    T findById(K id);

    List<T> findAll();

    boolean existsById(K id);
}
