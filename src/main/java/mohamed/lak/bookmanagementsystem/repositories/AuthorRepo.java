package mohamed.lak.bookmanagementsystem.repositories;

import mohamed.lak.bookmanagementsystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
