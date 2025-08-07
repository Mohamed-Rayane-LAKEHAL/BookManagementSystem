package mohamed.lak.bookmanagementsystem.controllers;

import mohamed.lak.bookmanagementsystem.entities.author;
import mohamed.lak.bookmanagementsystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public void AddAuthor(@RequestBody author author) {
        authorService.addAuthor(author);
    }
    @GetMapping("/authors")
    public List<author> RetrieveAuthors() {
        return authorService.getAllAuthors();
    }



}
