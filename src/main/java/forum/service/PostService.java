package forum.service;

import forum.model.Post;
import forum.persistance.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class is a post service
 *
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Service
public class PostService implements RepositoryService<Post> {
    /**
     * Storage
     */
    private final PostRepository store;

    @Autowired
    public PostService(PostRepository store) {
        this.store = store;
    }

    /**
     * Method add new user to DB
     *
     * @param some
     * @return Post
     */
    @Override
    public Post add(Post some) {
        return (Post) store.save(some);
    }

    /**
     * Method return optional user by given id from DB
     *
     * @param id
     * @return Optional
     */
    @Override
    public Optional<Post> findById(int id) {
        return store.findById(id);
    }

    /**
     * Method return all users from DB
     *
     * @return List
     */
    @Override
    public List<Post> findAll() {
        List<Post> rsl = new ArrayList<>();
        store.findAll().forEach(rsl::add);
        return rsl;
    }

    /**
     * Method execute update user in DB
     *
     * @param some
     */
    @Override
    public void update(Post some) {
        store.save(some);
    }
}
