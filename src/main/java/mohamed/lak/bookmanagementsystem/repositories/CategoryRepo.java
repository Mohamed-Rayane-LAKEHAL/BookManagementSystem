package mohamed.lak.bookmanagementsystem.repositories;

import mohamed.lak.bookmanagementsystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    @Query(nativeQuery = true, value = "Select name from category")
    List<String> retrieveCategoriesNames();

    Category findByName(String name);
}
