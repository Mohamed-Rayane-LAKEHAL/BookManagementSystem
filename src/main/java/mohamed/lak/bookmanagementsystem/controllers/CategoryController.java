package mohamed.lak.bookmanagementsystem.controllers;

import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.Category;
import mohamed.lak.bookmanagementsystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.retrieveAllCategories();
    }
    @PostMapping("/addCategory")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
    @PostMapping("/addCategories")
    public void addCategories(@RequestBody List<Category> categories) {
        categories.forEach(category -> categoryService.addCategory(category));
    }


}
