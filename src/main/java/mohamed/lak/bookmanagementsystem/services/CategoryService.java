package mohamed.lak.bookmanagementsystem.services;

import mohamed.lak.bookmanagementsystem.dto.BookDto;
import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.Category;
import mohamed.lak.bookmanagementsystem.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    //@Autowired
    CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category addCategory(Category category){
        Category c = categoryRepo.findAll().stream().filter(c1 -> c1.getId().equals(category.getId())).findFirst().orElse(null);
        if(c == null){
            categoryRepo.save(category);
            return category;
        }
        return c;
    }
    public List<Category> addMultipleCategories(List<Category> categories){
        List<String> newCategories = new ArrayList<>();
        List<String> addedNames = categories.stream().map(c->c.getName()).collect(Collectors.toList());
        List<String> dbNames = categoryRepo.retrieveCategoriesNames();
        for(String name : addedNames){
            boolean result = dbNames.contains(name);
            if (!result) newCategories.add(name);
        }
        List<Category> toSave = newCategories.stream().map(n->new Category(n)).collect(Collectors.toList());
        categoryRepo.saveAll(toSave);
        return toSave;
    }
    public List<Category> retrieveAllCategories(){
        return categoryRepo.findAll();
    }
    public BookDto toDto(Book book){
        BookDto Bdto = new BookDto(
                book.getId(),
                book.getTitle(),
                book.getISBN(),
                book.getGener(),
                book.getPubYear(),
                book.getCategories(),
                book.getAuthor().getName()
        );
        return Bdto;
    }
    public List<BookDto> getBooksByCategoryName(String CategoryName){

        Category category = categoryRepo.findByName(CategoryName);
        if(category == null)return null;
        List<Book> BooksToReturn = category.getBooks();
        return BooksToReturn.stream().map(b -> toDto(b)).collect(Collectors.toList());
    }




}
