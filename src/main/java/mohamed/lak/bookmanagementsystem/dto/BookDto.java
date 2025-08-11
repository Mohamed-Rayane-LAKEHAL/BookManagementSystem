package mohamed.lak.bookmanagementsystem.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import mohamed.lak.bookmanagementsystem.entities.Author;
import mohamed.lak.bookmanagementsystem.entities.Category;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record BookDto(
        Integer id,
        String title,
        String ISBN,
        String gener,
        @Temporal(TemporalType.DATE)
        LocalDate pubYear,
        List<Category> categories,
        Author author
){
}
