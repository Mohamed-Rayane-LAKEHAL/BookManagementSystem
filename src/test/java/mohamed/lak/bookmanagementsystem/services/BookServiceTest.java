package mohamed.lak.bookmanagementsystem.services;

import mohamed.lak.bookmanagementsystem.dto.BookDto;
import mohamed.lak.bookmanagementsystem.entities.Author;
import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.Category;
import mohamed.lak.bookmanagementsystem.repositories.BookRepo;
import mohamed.lak.bookmanagementsystem.repositories.CategoryRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    // which service we want to test
    @InjectMocks
    private BookService bookService;

    // what are the dependencies
    @Mock
    private BookRepo bookRepo;
    @Mock
    private CategoryRepo categoryRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void itShouldAddBook() {
        // given
        Author testAuthor = new Author(1, "testAuthor", "Scientist", "Algerian");
        LocalDate d1 = LocalDate.now();
        Book book = new Book(1, "testTitle", "test", "science", d1, testAuthor);
        // mock the calls
        Mockito.when(bookRepo.save(book)).thenReturn(book);
        // when
        BookDto dto = bookService.addBook(book);
        BookDto dto1 = bookService.toDto(book);
        // then
        assertEquals(dto, dto1);
    }

    @Test
    public void itShouldDeleteBookById() {
        // given
        Author testAuthor = new Author(1, "testAuthor", "Scientist", "Algerian");
        LocalDate d1 = LocalDate.now();
        Book book = new Book(1, "testTitle", "test", "science", d1, testAuthor);
        // mock the calls
        Mockito.when(bookRepo.findById(1)).thenReturn(Optional.of(book));
        // when
        String message = bookService.deleteBook(book.getId());
        // then
        assertEquals("Book deleted", message);
    }

    @Test
    public void itShouldUpdateBook() {
        // given
        Author testAuthor = new Author(1, "testAuthor", "Scientist", "Algerian");
        LocalDate d1 = LocalDate.now();
        Book book = new Book(1, "testTitle", "test", "science", d1, testAuthor);
        // mock the calls
        Mockito.when(bookRepo.findById(1)).thenReturn(Optional.of(book));
        // when
        BookDto returnedBook =  bookService.updateBook(book);
        BookDto newBook = bookService.toDto(book);
        // then
        assertEquals(newBook, returnedBook);
    }

    @Test
    public void itShouldGetAllBooks() {
        // given
        Author testAuthor = new Author(1, "testAuthor", "Scientist", "Algerian");
        LocalDate d1 = LocalDate.now();
        Book book = new Book(1, "testTitle", "test", "science", d1, testAuthor);
        List<Book> books = new ArrayList<>();
        books.add(book);
        // mock the calls
        Mockito.when(bookRepo.findAll()).thenReturn(books);
        // when
        List<BookDto> allBooks =  bookService.retrieveAllBooks();
        List<BookDto> returnedBooks = books.stream().map(b -> bookService.toDto(b)).collect(Collectors.toList());
        // then
        assertEquals(allBooks, returnedBooks);
    }

    @Test
    public void itShouldGetBookByTitle() {
        // given
        Author testAuthor = new Author(1, "testAuthor", "Scientist", "Algerian");
        LocalDate d1 = LocalDate.now();
        Book book = new Book(1, "testTitle", "test", "science", d1, testAuthor);
        // mock the calls
        Mockito.when(bookRepo.findByTitle(book.getTitle())).thenReturn(book);
        // when
        BookDto bookReturned = bookService.retrieveBookByTitle(book.getTitle());
        BookDto initialBook = bookService.toDto(book);
        // then
        assertEquals(bookReturned, initialBook);
    }

    @Test
    public void itShouldAddCategoryToBook(){
        // given
        Author testAuthor = new Author(1, "testAuthor", "Scientist", "Algerian");
        LocalDate d1 = LocalDate.now();
        Book book = new Book(1, "testTitle", "test", "science", d1, testAuthor);
        Category category = new Category(1, "testCategory");
        HashMap<String, String> map = new HashMap<>();
        map.put(book.getTitle(), category.getName());
        // mock the calls
        Mockito.when(bookRepo.findById(1)).thenReturn(Optional.of(book));
        Mockito.when(categoryRepo.findById(1)).thenReturn(Optional.of(category));
        Mockito.when(bookRepo.save(book)).thenReturn(book);
        Mockito.when(categoryRepo.save(category)).thenReturn(category);
        // when
        HashMap<String, String> returnedMap = bookService.addCategoryToBook(book.getId(), category.getId());
        // then
        assertEquals(map, returnedMap);
    }



}