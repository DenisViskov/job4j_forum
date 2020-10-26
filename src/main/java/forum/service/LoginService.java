package forum.service;

import forum.model.User;
import forum.persistance.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Service
public class LoginService implements Login<User> {
    private final Store store;

    @Autowired
    public LoginService(@Qualifier("userStorage") Store store) {
        this.store = store;
    }

    @Override
    public boolean validate(User some) {
        List<User> users = store.findAll();
        return users.stream()
                .anyMatch(user -> user.getName().equals(some.getName())
                        && user.getPassword().equals(some.getPassword()));
    }

}
