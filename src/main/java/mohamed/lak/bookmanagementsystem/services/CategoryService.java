package mohamed.lak.bookmanagementsystem.services;

import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.Category;
import mohamed.lak.bookmanagementsystem.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public void addCategory(Category category){
        categoryRepo.save(category);
    }
    public List<Category> retrieveAllCategories(){
        return categoryRepo.findAll();
    }

}
