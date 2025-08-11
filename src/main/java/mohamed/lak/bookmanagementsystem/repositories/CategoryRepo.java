package mohamed.lak.bookmanagementsystem.repositories;

import mohamed.lak.bookmanagementsystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
