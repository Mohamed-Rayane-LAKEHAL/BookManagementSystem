package mohamed.lak.bookmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mohamed.lak.bookmanagementsystem.security.user;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class userProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private LocalDate borrowedDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    @JsonManagedReference
    private Set<Book> borrowedBooks = new HashSet<>();

    @OneToOne
    @MapsId
    private user user;


}
