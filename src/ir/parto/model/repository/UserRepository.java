package ir.parto.model.repository;

import ir.parto.model.entity.User;
import org.logicalcobwebs.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class UserRepository {
    public User insertUser(User user){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        user.setCreatedAt(LocalDateTime.now()).setUpdatedAt(LocalDateTime.now());
        entityManager.persist(user);

        entityTransaction.commit();
        entityManager.close();

        return user;
    }

    public User updateUser(User user){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User userUpdate = entityManager.find(User.class, user.getId());
        userUpdate.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(userUpdate);

        entityTransaction.commit();
        entityManager.close();

        return user;
    }

    public List<User> deleteUser(User user){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User userDelete = entityManager.find(User.class, user.getId());
        entityManager.remove(userDelete);

        Query query = entityManager.createQuery("select u from User u ", User.class);
        List<User> userList = query.getResultList();

        entityTransaction.commit();
        entityManager.close();

        return userList;
    }

    public List<User> selectUser(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createQuery("select u from User u ", User.class);
        List<User> userList = query.getResultList();

        entityTransaction.commit();
        entityManager.close();

        return userList;
    }

    public User selectOneUser(User user) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User userSelect = entityManager.find(User.class, user.getId());

        entityTransaction.commit();
        entityManager.close();

        return userSelect;
    }
}
