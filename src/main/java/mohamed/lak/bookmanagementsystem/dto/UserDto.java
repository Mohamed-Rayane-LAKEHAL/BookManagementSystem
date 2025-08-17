package mohamed.lak.bookmanagementsystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import mohamed.lak.bookmanagementsystem.entities.Book;

import java.time.LocalDate;
import java.util.List;

public record UserDto(
        Integer id,
        String username,
        String Role,
        @Temporal(TemporalType.DATE)
        LocalDate borrowedDate,
        List<Book> borrowedBooks
        ){
}
