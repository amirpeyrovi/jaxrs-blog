package ir.parto.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "jaxrs_blog_category")
public class Category implements Serializable {
    @Id
    @SequenceGenerator(name = "jaxrs_blog_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jaxrs_blog_seq")
    private Long id;
    private String title;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public Category() {
    }

    public Category(String title, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Category setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Category setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Category setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
