package mohamed.lak.bookmanagementsystem.controllers;

import mohamed.lak.bookmanagementsystem.dto.BookDto;
import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.Category;
import mohamed.lak.bookmanagementsystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {
    //@Autowired
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.retrieveAllCategories(), HttpStatus.OK);
    }
    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category c = categoryService.addCategory(category);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    @PostMapping("/addCategories")
    public ResponseEntity<List<Category>> addCategories(@RequestBody List<Category> categories) {
        List<Category> addedCategories = categoryService.addMultipleCategories(categories);
        return new ResponseEntity<>(addedCategories, HttpStatus.OK);

    }
    @GetMapping("/BooksByCategoryName/{CategoryName}")
    public ResponseEntity<List<BookDto>> booksByCategoryName(@PathVariable String CategoryName) {
        List<BookDto> books = categoryService.getBooksByCategoryName(CategoryName);
        if(books ==null)return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

}
