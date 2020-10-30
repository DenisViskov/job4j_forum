package forum.service;

import java.util.List;
import java.util.Optional;

/**
 * Interface of Repository service
 *
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
public interface RepositoryService<V> {
    /**
     * Method should add new object to DB
     *
     * @param some
     * @return V
     */
    V add(V some);

    /**
     * Method should return optional object from DB by given ID
     *
     * @param id
     * @return Optional
     */
    Optional<V> findById(int id);

    /**
     * Method should return all elements from DB
     *
     * @return List
     */
    List<V> findAll();

    /**
     * Method should update object in DB
     *
     * @param some
     */
    void update(V some);
}
