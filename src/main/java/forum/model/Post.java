package forum.model;

import java.util.Calendar;
import java.util.Objects;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 26.10.2020
 */
public class Post {
    private int id;
    private String name;
    private String desc;
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
