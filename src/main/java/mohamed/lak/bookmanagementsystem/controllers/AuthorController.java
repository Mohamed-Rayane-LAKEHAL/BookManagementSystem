package mohamed.lak.bookmanagementsystem.controllers;
import jakarta.validation.Valid;
import mohamed.lak.bookmanagementsystem.entities.Author;
import mohamed.lak.bookmanagementsystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class AuthorController {
    //@Autowired
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/addAuthor")
    public void addAuthor(@Valid @RequestBody Author author) {
        authorService.addAuthor(author);
    }
    @GetMapping("/authors")
    public List<Author> retrieveAuthors() {
        return authorService.getAllAuthors();
    }



}
