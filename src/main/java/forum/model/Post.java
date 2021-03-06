package forum.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

/**
 * Class is a Post entity
 *
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
@Entity
@Table(name = "posts")
public class Post {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Name
     */
    @Column(name = "name")
    private String name;
    /**
     * Description
     */
    @Column(name = "description")
    private String desc;
    /**
     * Created date
     */
    @Column(name = "created")
    private Calendar created;

    public Post() {
    }

    public Post(int id, String name, String desc, Calendar created) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public static Post of(String name) {
        Post post = new Post();
        post.name = name;
        return post;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(name, post.name) &&
                Objects.equals(desc, post.desc) &&
                Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created);
    }
}
