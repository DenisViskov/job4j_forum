package forum.persistance;

import forum.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Repository
public class UserStorage implements Store<User> {
    private final List<User> users = new ArrayList<>();

    @Override
    public User add(User some) {
        users.add(some);
        return some;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
