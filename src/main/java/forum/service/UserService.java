package forum.service;

import forum.model.User;
import forum.persistance.Store;
import forum.persistance.UserRepository;
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
public class UserService implements RepositoryService<User> {
    private final UserRepository store;

    @Autowired
    public UserService(UserRepository store) {
        this.store = store;
    }

    @Override
    public User add(User some) {
        return (User) store.save(some);
    }

    @Override
    public Optional<User> findById(int id) {
        return store.findById(id);
    }

    @Override
    public List<User> findAll() {
        List<User> rsl = new ArrayList<>();
        store.findAll().forEach(rsl::add);
        return rsl;
    }

    @Override
    public void update(User some) {
        store.save(some);
    }
}
