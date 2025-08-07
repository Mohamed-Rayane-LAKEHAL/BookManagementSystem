package mohamed.lak.bookmanagementsystem.services;

import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.category;
import mohamed.lak.bookmanagementsystem.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public void AddCategory(category category){
        categoryRepo.save(category);
    }
    public List<category> RetrieveAllCategories(){
        return categoryRepo.findAll();
    }

}
