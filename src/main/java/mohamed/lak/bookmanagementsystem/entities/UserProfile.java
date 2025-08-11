package mohamed.lak.bookmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mohamed.lak.bookmanagementsystem.security.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user_profile;

    @Temporal(TemporalType.DATE)
    private LocalDate borrowedDate;

    @ManyToMany()
    @JoinTable(name = "user_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> borrowedBooks = new ArrayList<>();

    @OneToOne
    @MapsId
    private Users user;


}
