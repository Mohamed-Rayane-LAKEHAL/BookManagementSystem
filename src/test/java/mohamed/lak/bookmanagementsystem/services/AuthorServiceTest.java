package mohamed.lak.bookmanagementsystem.services;

import mohamed.lak.bookmanagementsystem.entities.Author;
import mohamed.lak.bookmanagementsystem.repositories.AuthorRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorServiceTest {

    //which service we want to test
    @InjectMocks
    private AuthorService authorService;

    @Mock
    // what are the dependencies
    AuthorRepo authorRepo;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void itShouldAddAuthor() {
        // given
        Author testAuthor = new Author(1, "testAuthor", "Scientist", "Algerian");
        // mock the calls
        Mockito.when(authorRepo.save(testAuthor)).thenReturn(testAuthor);
        // when
        Author author = authorService.addAuthor(testAuthor);
        // then
        assertEquals(testAuthor.getId(), author.getId());
        assertEquals(testAuthor.getName(), author.getName());
        assertEquals(testAuthor.getBibliography(), author.getBibliography());
        assertEquals(testAuthor.getNationality(), author.getNationality());
        Mockito.verify(authorRepo, Mockito.times(1)).save(testAuthor);
    }

    @Test
    public void itShouldRetrieveAllAuthors() {
        // given
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(1, "testAuthor", "Scientist", "Algerian"));
        // mock the calls
        Mockito.when(authorRepo.findAll()).thenReturn(authors);
        // when
        List<Author> allAuthors = authorService.getAllAuthors();
        // then
        assertEquals(allAuthors.size(), authors.size());
    }


}