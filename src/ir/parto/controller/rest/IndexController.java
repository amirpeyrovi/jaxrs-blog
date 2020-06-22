package ir.parto.controller.rest;

import ir.parto.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class IndexController {

    @Path("/")
    @GET
    @Produces("Application/json")
    public Object index() {
        System.out.println("salam0");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jaxrsBlog");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        System.out.println("salam1");
        User user = new User().setFistName("Amir").setLastName("Peyrovi").setPhoneNumber("09126799539")
                .setUsername("amirpeyro").setPassword("123456");
        entityManager.persist(user);
        System.out.println("salam2");
        entityTransaction.commit();

        return user;
    }



}
