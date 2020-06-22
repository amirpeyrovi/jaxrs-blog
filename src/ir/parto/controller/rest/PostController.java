package ir.parto.controller.rest;

import ir.parto.model.entity.Category;
import ir.parto.model.entity.Post;
import ir.parto.model.entity.User;
import ir.parto.model.service.PostService;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/post")
public class PostController {
    PostService postService = new PostService();

    @Path("/add")
    @POST
    @Produces("Application/json")
    public Object addAction(@QueryParam("title") String title, @QueryParam("description") String description, @QueryParam("userId") String userId, @QueryParam("categoriesId") List<String> categoriesId){
        User user = new User().setId(Long.parseLong(userId));
        
        List<Category> categoryList = new ArrayList();
        for (String categoryId : categoriesId){
            Category category = new Category().setId(Long.parseLong(categoryId));
            categoryList.add(category);
        }

        Post post = new Post()
                .setTitle(title)
                .setDescription(description)
                .setUser(user)
                .setCategories(categoryList);
        return postService.addPost(post);
    }

    @Path("/update")
    @PUT
    @Produces("Application/json")
    public Object updateAction(@QueryParam("id") String id, @QueryParam("title") String title, @QueryParam("description") String description, @QueryParam("userId") String userId, @QueryParam("categoriesId") List<String> categoriesId){
        User user = new User().setId(Long.parseLong(userId));

        List<Category> categoryList = new ArrayList();
        for (String categoryId : categoriesId){
            Category category = new Category().setId(Long.parseLong(categoryId));
            categoryList.add(category);
        }

        Post post = new Post()
                .setId(Long.parseLong(id))
                .setTitle(title)
                .setDescription(description)
                .setUser(user)
                .setCategories(categoryList);
        return postService.addPost(post);
    }

    @Path("/remove")
    @DELETE
    @Produces("Application/json")
    public Object removeAction(@QueryParam("id") String id){
        Post post = new Post().setId(Long.parseLong(id));
        return postService.removePost(post);
    }

    @Path("/")
    @GET
    @Produces("Application/json")
    public Object findAllAction(){
        return postService.findAllPost();
    }

    @Path("/{id}")
    @GET
    @Produces("Application/json")
    public Object findAction(@PathParam("id") String id){
        Post post = new Post().setId(Long.parseLong(id));
        return postService.findPost(post);
    }
}
