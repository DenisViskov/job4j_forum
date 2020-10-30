package forum.persistance;

import forum.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface of user repository
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.10.2020
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * Method should return user by given name from DB
     *
     * @param name
     * @return User
     */
    User findByName(String name);
}
