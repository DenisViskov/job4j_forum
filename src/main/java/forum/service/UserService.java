package forum.service;

import forum.model.Role;
import forum.model.User;
import forum.persistance.RoleRepository;
import forum.persistance.Store;
import forum.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Service
public class UserService implements RepositoryService<User>, UserDetailsService {
    private final UserRepository store;
    private final RoleRepository roleStore;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository store, RoleRepository roleStore, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.store = store;
        this.roleStore = roleStore;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User add(User some) {
        some.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        some.setPassword(bCryptPasswordEncoder.encode(some.getPassword()));
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
        if(store.findById(some.getId()).isPresent())
        store.save(some);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
