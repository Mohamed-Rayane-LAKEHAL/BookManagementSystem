package mohamed.lak.bookmanagementsystem.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import mohamed.lak.bookmanagementsystem.security.user;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String ISBN;
    private String gener;
    @Temporal(TemporalType.DATE)
    private LocalDate pubYear;

    @ManyToOne
    @JsonBackReference //indicates that the annotated property (author) should be ignored during serialization to break the cycle
    private author author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<category> categories = new ArrayList<>();

    @ManyToMany(mappedBy = "borrowedBooks", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<userProfile> users = new ArrayList<>();

    public String ToString(){
        return "Book: "+ " Id: " + id + " title: "+ title + " ISBN: " + ISBN + " pubYear: " + pubYear;
    }

}
