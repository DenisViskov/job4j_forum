package forum.service;

import forum.model.User;
import forum.persistance.Store;
import forum.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Service
public class LoginService implements Login<User> {
    private final UserRepository store;

    @Autowired
    public LoginService(UserRepository store) {
        this.store = store;
    }

    @Override
    public boolean validate(User some) {
        List<User> users = new ArrayList<>();
        store.findAll().forEach(users::add);
        return users.stream()
                .anyMatch(user -> user.getName().equals(some.getName())
                        && user.getPassword().equals(some.getPassword()));
    }
}
