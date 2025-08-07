package mohamed.lak.bookmanagementsystem.services;

import mohamed.lak.bookmanagementsystem.entities.author;
import mohamed.lak.bookmanagementsystem.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;

    public void addAuthor(author author) {
        authorRepo.save(author);
    }
    public List<author> getAllAuthors() {
        return authorRepo.findAll();
    }

}
