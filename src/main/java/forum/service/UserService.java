package forum.service;

import forum.model.Role;
import forum.model.User;
import forum.persistance.RoleRepository;
import forum.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Class is an user service
 *
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Service
public class UserService implements RepositoryService<User>, UserDetailsService {
    /**
     * Storage
     */
    private final UserRepository store;
    /**
     * Password encoder
     */
    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository store, PasswordEncoder bCryptPasswordEncoder) {
        this.store = store;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * Method set role for new user and encrypt password
     * and then save him on storage
     *
     * @param some
     * @return User
     */
    @Override
    public User add(User some) {
        some.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        some.setPassword(bCryptPasswordEncoder.encode(some.getPassword()));
        return (User) store.save(some);
    }

    /**
     * Method return optional user by given ID from DB
     *
     * @param id
     * @return Optional
     */
    @Override
    public Optional<User> findById(int id) {
        return store.findById(id);
    }

    /**
     * Method returns all users from DB
     *
     * @return List
     */
    @Override
    public List<User> findAll() {
        List<User> rsl = new ArrayList<>();
        store.findAll().forEach(rsl::add);
        return rsl;
    }

    /**
     * Method execute update user into DB
     *
     * @param some
     */
    @Override
    public void update(User some) {
        if (store.findById(some.getId()).isPresent()) {
            store.save(some);
        }
    }

    /**
     * Implementation loadUserByUsername from UserDetailService interface
     *
     * @param s
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = store.findByName(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
