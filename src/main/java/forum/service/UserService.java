package forum.service;

import forum.model.User;
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
public class UserService implements RepositoryService<User> {
    private final Store store;
    private int id;

    @Autowired
    public UserService(@Qualifier("userStorage") Store store) {
        this.store = store;
    }

    @Override
    public User add(User some) {
        some.setId(id++);
        return (User) store.add(some);
    }

    @Override
    public Optional<User> findById(int id) {
        List<User> users = store.findAll();
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return store.findAll();
    }

    @Override
    public void update(User some) {
        List<User> all = store.findAll();
        all.set(some.getId(), some);
    }
}
