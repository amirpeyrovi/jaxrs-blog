package ir.parto.model.repository;

import ir.parto.model.entity.Post;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class PostRepository {
    public Post insertPost(Post post){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        post.setCreatedAt(LocalDateTime.now()).setUpdatedAt(LocalDateTime.now());
        entityManager.persist(post);

        entityTransaction.commit();
        entityManager.close();

        return post;
    }

    public Post updatePost(Post post){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Post postUpdate = entityManager.find(Post.class, post.getId());
        postUpdate.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(postUpdate);

        entityTransaction.commit();
        entityManager.close();

        return post;
    }

    public List<Post> deletePost(Post post){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Post postDelete = entityManager.find(Post.class, post.getId());
        entityManager.remove(postDelete);

        Query query = entityManager.createQuery("select p from Post p ", Post.class);
        List<Post> postList = query.getResultList();

        entityTransaction.commit();
        entityManager.close();

        return postList;
    }

    public List<Post> selectPost(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createQuery("select p from Post p ", Post.class);
        List<Post> postList = query.getResultList();

        entityTransaction.commit();
        entityManager.close();

        return postList;
    }

    public Post selectOnePost(Post post) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Post postSelect = entityManager.find(Post.class, post.getId());

        entityTransaction.commit();
        entityManager.close();

        return postSelect;
    }
}
