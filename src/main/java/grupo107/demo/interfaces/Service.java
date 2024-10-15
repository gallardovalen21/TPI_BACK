package grupo107.demo.interfaces;

import java.util.List;

public interface Service<T,K> {
    void create(T entity);

    void update(T entity);

    T delete(K id);

    T findById(K id);

    List<T> findAll();

    boolean existsById(K id);
}
