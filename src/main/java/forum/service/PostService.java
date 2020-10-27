package forum.service;

import forum.model.Post;
import forum.persistance.PostRepository;
import forum.persistance.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Service
public class PostService implements RepositoryService<Post> {
    private final PostRepository store;

    @Autowired
    public PostService(PostRepository store) {
        this.store = store;
    }

    @Override
    public Post add(Post some) {
        return (Post) store.save(some);
    }

    @Override
    public Optional<Post> findById(int id) {
        return store.findById(id);
    }

    @Override
    public List<Post> findAll() {
        List<Post> rsl = new ArrayList<>();
        store.findAll().forEach(rsl::add);
        return rsl;
    }

    @Override
    public void update(Post some) {
        store.save(some);
    }
}
