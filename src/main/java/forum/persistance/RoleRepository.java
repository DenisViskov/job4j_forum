package forum.persistance;

import forum.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface of role repository
 *
 * @author Денис Висков
 * @version 1.0
 * @since 28.10.2020
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
