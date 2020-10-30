package forum.persistance;

import forum.model.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface of post repository
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.10.2020
 */
public interface PostRepository extends CrudRepository<Post, Integer> {
}
