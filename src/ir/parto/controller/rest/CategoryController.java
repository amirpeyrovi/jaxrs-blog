package ir.parto.controller.rest;

import ir.parto.model.entity.Category;
import ir.parto.model.service.CategoryService;

import javax.ws.rs.*;

@Path("/category")
public class CategoryController {
    CategoryService categoryService = new CategoryService();

    @Path("/add")
    @POST
    @Produces("Application/json")
    public Object addAction(@QueryParam("title") String title){
        Category category = new Category()
                .setTitle(title);
        return categoryService.addCategory(category);
    }

    @Path("/update")
    @PUT
    @Produces("Application/json")
    public Object updateAction(@QueryParam("id") String id, @QueryParam("title") String title){
        Category category = new Category()
                .setId(Long.parseLong(id))
                .setTitle(title);
        return categoryService.updateCategory(category);
    }

    @Path("/remove")
    @DELETE
    @Produces("Application/json")
    public Object removeAction(@QueryParam("id") String id){
        Category category = new Category().setId(Long.parseLong(id));
        return categoryService.removeCategory(category);
    }

    @Path("/")
    @GET
    @Produces("Application/json")
    public Object findAllAction(){
        return categoryService.findAllCategory();
    }

    @Path("/{id}")
    @GET
    @Produces("Application/json")
    public Object findAction(@PathParam("id") String id){
        Category category = new Category().setId(Long.parseLong(id));
        return categoryService.findCategory(category);
    }
}
