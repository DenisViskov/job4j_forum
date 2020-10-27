package forum.persistance;

import forum.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Repository
public class PostStorage implements Store<Post> {
    private final List<Post> posts = new ArrayList<>();

    @Override
    public Post add(Post some) {
        posts.add(some);
        return some;
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }
}
