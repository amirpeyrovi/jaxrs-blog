package ir.parto.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "jaxrs_blog_posts")
public class Post implements Serializable {
    @Id
    @SequenceGenerator(name = "jaxrs_blog_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jaxrs_blog_seq")
    private Long id;

    private String title;

    @Column(columnDefinition = "varchar2(256)")
    private String description;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Category> categories;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public Post() {
    }

    public Post(String title, String description, User user, List<Category> categories, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.categories = categories;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Post setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Post setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Post setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Post setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Post setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
