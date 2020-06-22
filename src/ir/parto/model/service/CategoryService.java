package ir.parto.model.service;

import ir.parto.model.entity.Category;
import ir.parto.model.repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    CategoryRepository categoryRepository = new CategoryRepository();

    public Category addCategory(Category category){
        return categoryRepository.insertCategory(category);
    }

    public Category updateCategory(Category category){
        return categoryRepository.updateCategory(category);
    }

    public List<Category> removeCategory(Category category) {
        return categoryRepository.deleteCategory(category);
    }

    public List<Category> findAllCategory() {
        return categoryRepository.selectCategory();
    }

    public Category findCategory(Category category){
        return categoryRepository.selectOneCategory(category);
    }
}
