package forum.service;

import forum.model.Post;
import forum.persistance.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Service
public class PostService implements RepositoryService<Post> {
    private final Store store;

    @Autowired
    public PostService(@Qualifier("postStorage") Store store) {
        this.store = store;
        store.add(Post.of("Sale car lada"));
    }

    @Override
    public Post add(Post some) {
        return (Post) store.add(some);
    }

    @Override
    public Optional<Post> findById(int id) {
        List<Post> posts = store.findAll();
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst();
    }

    @Override
    public List<Post> findAll() {
        return store.findAll();
    }

    @Override
    public void update(Post some) {
        List<Post> all = findAll();
        all.set(some.getId() - 1, some);
    }
}
