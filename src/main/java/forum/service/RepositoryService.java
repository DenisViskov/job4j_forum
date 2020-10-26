package forum.service;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
public interface RepositoryService<V> {
    V add(V some);

    Optional<V> findById(int id);

    List<V> findAll();
}
