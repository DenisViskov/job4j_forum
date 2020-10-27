package forum.persistance;

import forum.model.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс реализующий способность
 *
 * @author Денис Висков
 * @version 1.0
 * @since 27.10.2020
 */
public interface PostRepository extends CrudRepository<Post, Integer> {
}
