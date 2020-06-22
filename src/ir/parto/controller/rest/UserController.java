package ir.parto.controller.rest;

import ir.parto.model.entity.User;
import ir.parto.model.service.UserService;

import javax.ws.rs.*;

@Path("/user")
public class UserController {
    UserService userService = new UserService();

    @Path("/add")
    @POST
    @Produces("Application/json")
    public Object addAction(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("address") String address, @QueryParam("phoneNumber") String phoneNumber, @QueryParam("country") String country, @QueryParam("province") String province, @QueryParam("city") String city){
        User user = new User()
                .setFistName(firstName)
                .setLastName(lastName)
                .setUsername(username)
                .setPassword(password)
                .setAddress(address)
                .setPhoneNumber(phoneNumber)
                .setCountry(country)
                .setProvince(province)
                .setCity(city);
        return userService.addUser(user);
    }

    @Path("/update")
    @PUT
    @Produces("Application/json")
    public Object updateAction(@QueryParam("id") String id, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("address") String address, @QueryParam("phoneNumber") String phoneNumber, @QueryParam("country") String country, @QueryParam("province") String province, @QueryParam("city") String city){
        User user = new User()
                .setId(Long.parseLong(id))
                .setFistName(firstName)
                .setLastName(lastName)
                .setUsername(username)
                .setPassword(password)
                .setAddress(address)
                .setPhoneNumber(phoneNumber)
                .setCountry(country)
                .setProvince(province)
                .setCity(city);
        return userService.updateUser(user);
    }

    @Path("/remove")
    @DELETE
    @Produces("Application/json")
    public Object removeAction(@QueryParam("id") String id){
        User user = new User().setId(Long.parseLong(id));
        return userService.removeUser(user);
    }

    @Path("/")
    @GET
    @Produces("Application/json")
    public Object findAllAction(){
        return userService.findAllUser();
    }

    @Path("/{id}")
    @GET
    @Produces("Application/json")
    public Object findAction(@PathParam("id") String id){
        User user = new User().setId(Long.parseLong(id));
        return userService.findUser(user);
    }
}
