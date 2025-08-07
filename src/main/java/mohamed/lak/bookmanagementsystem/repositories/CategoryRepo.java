package mohamed.lak.bookmanagementsystem.repositories;

import mohamed.lak.bookmanagementsystem.entities.category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<category, Integer> {
}
