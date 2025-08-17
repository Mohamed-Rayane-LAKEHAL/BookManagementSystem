package mohamed.lak.bookmanagementsystem.services;

import mohamed.lak.bookmanagementsystem.dto.BookDto;
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
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    //@Autowired
    private BookRepo bookRepo;
    //@Autowired
    private CategoryRepo categoryRepo;

    public BookService(BookRepo bookRepo, CategoryRepo categoryRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
    }


    public BookDto addBook(Book book){
        bookRepo.save(book);
        return toDto(book);
    }
    public String deleteBook(Integer id){
        Book book = bookRepo.findById(id).orElse(null);
        if(book == null) return null;
        bookRepo.deleteById(id);
        return "Book deleted";
    }
    public BookDto updateBook(Book book){
         Book Book = bookRepo.findById(book.getId()).orElse(null);
         if (Book == null) return null;
         Book.setAuthor(book.getAuthor());
         Book.setTitle(book.getTitle());
         Book.setGener(book.getGener());
         Book.setISBN(book.getISBN());
         Book.setPubYear(book.getPubYear());
         Book.setCategories(book.getCategories());
         bookRepo.save(Book);
         return toDto(Book);
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
    public List<BookDto> retrieveAllBooks(){
        List<Book> allBooks = bookRepo.findAll();
        return allBooks.stream().map(b -> toDto(b)).collect(Collectors.toList());
    }
    public BookDto retrieveBookByTitle(String title){
        Book book = bookRepo.findByTitle(title);
        if (book == null) return null;
        return toDto(book);
    }
    public HashMap<String, String> addCategoryToBook(Integer id_book, Integer id_category){
        HashMap<String, String> book_categeory = new HashMap<>();
        Book book = bookRepo.findById(id_book).orElse(null);
        Category category = categoryRepo.findById(id_category).orElse(null);
        if(book == null || category == null ){
            book_categeory.put("Book not availabe", "Category Not availabe");
            return book_categeory;
        }
        List<Category> categories = book.getCategories();
        if(categories.contains(category)){
            book_categeory.put(book.getTitle(), "Already belongs to " + category.getName() + " category");
            return book_categeory;
        }
        Boolean bool = categories.add(category);
        book.setCategories(categories);
        bookRepo.save(book);
        List<Book> books = category.getBooks();
        Boolean bool2 = books.add(book);
        category.setBooks(books);
        categoryRepo.save(category);
        book_categeory.put(book.getTitle(), category.getName());
        return book_categeory;
    }
    public Page<Book> findAll(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }

}
