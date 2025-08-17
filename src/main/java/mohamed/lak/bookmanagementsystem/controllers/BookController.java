package mohamed.lak.bookmanagementsystem.controllers;

import mohamed.lak.bookmanagementsystem.dto.BookDto;
import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.Author;
import mohamed.lak.bookmanagementsystem.entities.Category;
import mohamed.lak.bookmanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@RestController
public class BookController {
    //@Autowired
    private BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return new ResponseEntity<>(bookService.retrieveAllBooks(), HttpStatus.OK);
    }
    @PostMapping("/addBook")
    public ResponseEntity<BookDto> addBook(@RequestBody Book book){
        BookDto bookDto =  bookService.addBook(book);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }
    @PostMapping("/addBooks")
    public void addBooks(@RequestBody List<Book> books){
        books.forEach(book -> bookService.addBook(book));
    }
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        String message = bookService.deleteBook(id);
        if (message ==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping("/updateBook") //ok
    public ResponseEntity<BookDto> updateBook(@RequestBody Book book){
        BookDto bookDto = bookService.updateBook(book);
        if(bookDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }
    @GetMapping("/books/{title}")
    public ResponseEntity<BookDto> searchBookByTitle(@PathVariable String title){
        BookDto bookDto = bookService.retrieveBookByTitle(title);
        if(bookDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }
    @PutMapping("/{id_book}/categoryToBook/{id_category}")
    public ResponseEntity<HashMap<String, String>> addCategoryToBook(@PathVariable Integer id_book, @PathVariable Integer id_category){
        HashMap<String, String> book_category = bookService.addCategoryToBook(id_book, id_category);
        return new ResponseEntity<>(book_category, HttpStatus.OK);
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







}
