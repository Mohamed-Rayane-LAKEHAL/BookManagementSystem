package mohamed.lak.bookmanagementsystem.controllers;

import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.author;
import mohamed.lak.bookmanagementsystem.entities.category;
import mohamed.lak.bookmanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> GetAllBooks() {
        return bookService.RetrieveAllBooks();
    }
    @PostMapping("/addBook")
    public void AddBook(@RequestBody Book book){
        bookService.AddBook(book);
    }
    @PostMapping("/addBooks")
    public void AddBooks(@RequestBody List<Book> books){
        books.forEach(book -> bookService.AddBook(book));
    }
    @DeleteMapping("/deleteBook/{id}")
    public void DeleteBook(@PathVariable Integer id){
        bookService.DeleteBook(id);
    }
    @PutMapping("/updateBook")
    public void UpdateBook(@RequestBody Book book){
        bookService.Updatebook(book);
    }
    @GetMapping("/books/{title}")
    public Book SearchBookByTitle(@PathVariable String title){
        return bookService.RetrieveBookByTitle(title);
    }
    @GetMapping("/booksPage")
    public Page<Book> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return bookService.findAll(pageable);
    }

    @PutMapping("/{id_book}/categoryToBook/{id_category}")
    public void AddCategoryToBook(@PathVariable Integer id_book, @PathVariable Integer id_category){
        bookService.AddCategoryToBook(id_book, id_category);
    }

    @GetMapping("/BooksByCategoryName/{CategoryName}")
    public List<Book> BooksByCategoryName(@PathVariable String CategoryName) {
        return bookService.GetBooksByCategory(CategoryName);
    }




}
