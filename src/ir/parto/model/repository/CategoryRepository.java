package ir.parto.model.repository;

import ir.parto.model.entity.Category;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class CategoryRepository {
    public Category insertCategory(Category category){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        category.setCreatedAt(LocalDateTime.now()).setUpdatedAt(LocalDateTime.now());
        entityManager.persist(category);

        entityTransaction.commit();
        entityManager.close();

        return category;
    }

    public Category updateCategory(Category category){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Category categoryUpdate = entityManager.find(Category.class, category.getId());
        categoryUpdate.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(categoryUpdate);

        entityTransaction.commit();
        entityManager.close();

        return category;
    }

    public List<Category> deleteCategory(Category category){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Category categoryDelete = entityManager.find(Category.class, category.getId());
        entityManager.remove(categoryDelete);

        Query query = entityManager.createQuery("select c from Category c ", Category.class);
        List<Category> userList = query.getResultList();

        entityTransaction.commit();
        entityManager.close();

        return userList;
    }

    public List<Category> selectCategory(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createQuery("select u from Category u ", Category.class);
        List<Category> userList = query.getResultList();

        entityTransaction.commit();
        entityManager.close();

        return userList;
    }

    public Category selectOneCategory(Category category) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Category categorySelect = entityManager.find(Category.class, category.getId());

        entityTransaction.commit();
        entityManager.close();

        return categorySelect;
    }
}
