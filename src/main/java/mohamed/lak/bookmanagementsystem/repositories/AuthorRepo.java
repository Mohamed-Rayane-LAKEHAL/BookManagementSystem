package mohamed.lak.bookmanagementsystem.repositories;

import mohamed.lak.bookmanagementsystem.entities.author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<author, Integer> {
}
