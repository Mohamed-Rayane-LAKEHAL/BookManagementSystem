package mohamed.lak.bookmanagementsystem.controllers;

import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.category;
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
    public List<category> GetAllCategories() {
        return categoryService.RetrieveAllCategories();
    }
    @PostMapping("/addCategory")
    public void AddCategory(@RequestBody category category) {
        categoryService.AddCategory(category);
    }
    @PostMapping("/addCategories")
    public void AddCategories(@RequestBody List<category> categories) {
        categories.forEach(category -> categoryService.AddCategory(category));
    }


}
