package forum.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Class is a role entity
 *
 * @author Денис Висков
 * @version 1.0
 * @since 28.10.2020
 */
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    /**
     * Id
     */
    @Id
    private int id;
    /**
     * Name
     */
    @Column(name = "name")
    private String name;
    /**
     * Users
     */
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(int id) {
        this.id = id;
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
