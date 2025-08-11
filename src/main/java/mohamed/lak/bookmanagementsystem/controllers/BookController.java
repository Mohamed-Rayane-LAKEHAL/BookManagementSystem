package mohamed.lak.bookmanagementsystem.controllers;

import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.Author;
import mohamed.lak.bookmanagementsystem.entities.Category;
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
    public List<Book> getAllBooks() {
        return bookService.retrieveAllBooks();
    }
    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
    @PostMapping("/addBooks")
    public void addBooks(@RequestBody List<Book> books){
        books.forEach(book -> bookService.addBook(book));
    }
    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }
    @PutMapping("/updateBook")
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }
    @GetMapping("/books/{title}")
    public Book searchBookByTitle(@PathVariable String title){
        return bookService.retrieveBookByTitle(title);
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
    public void addCategoryToBook(@PathVariable Integer id_book, @PathVariable Integer id_category){
        bookService.addCategoryToBook(id_book, id_category);
    }

    @GetMapping("/BooksByCategoryName/{CategoryName}")
    public List<Book> booksByCategoryName(@PathVariable String CategoryName) {
        return bookService.getBooksByCategory(CategoryName);
    }




}
