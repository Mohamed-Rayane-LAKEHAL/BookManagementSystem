package mohamed.lak.bookmanagementsystem.services;

import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.Author;
import mohamed.lak.bookmanagementsystem.entities.Category;
import mohamed.lak.bookmanagementsystem.repositories.BookRepo;
import mohamed.lak.bookmanagementsystem.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    
    public void addBook(Book book){
        bookRepo.save(book);
    }
    public List<Book> retrieveAllBooks(){
        return bookRepo.findAll();
    }
    public void deleteBook(Integer id){
        bookRepo.deleteById(id);
    }
    public void updateBook(Book book){
     Integer id = book.getId();
     Book Book = bookRepo.findAll().stream().filter(b -> b.getId().equals(id)).findFirst().orElseThrow();
     Book.setAuthor(book.getAuthor());
     Book.setTitle(book.getTitle());
     Book.setGener(book.getGener());
     Book.setISBN(book.getISBN());
     Book.setPubYear(book.getPubYear());
     bookRepo.save(Book);
    }
    public Book retrieveBookByTitle(String title){
        return bookRepo.findAll().stream().filter(b -> b.getTitle().equals(title)).findFirst().orElseThrow();
    }
    public Page<Book> findAll(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }
    public void addCategoryToBook(Integer id_book, Integer id_category){
        Book book = bookRepo.findAll().stream().filter(b -> b.getId().equals(id_book)).findFirst().orElseThrow();
        Category category = categoryRepo.findAll().stream().filter(c -> c.getId().equals(id_category)).findFirst().orElseThrow();
        List<Category> categories = book.getCategories();
        Boolean b = categories.add(category);
        book.setCategories(categories);
        List<Book> books = category.getBooks();
        Boolean b2 = books.add(book);
        category.setBooks(books);
        categoryRepo.save(category);
        bookRepo.save(book);
    }

    public List<Book> getBooksByCategory(String CategoryName){
        List<Book> BooksToReturn = new ArrayList<>();
        List<Book> books = bookRepo.findAll();
        for (Book book : books) {
            for(Category cat : book.getCategories()){
                if (cat.getName().equals(CategoryName)){
                    BooksToReturn.add(book);
                }
            }
        }

        return BooksToReturn;
    }


}
