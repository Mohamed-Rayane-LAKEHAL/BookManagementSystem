package mohamed.lak.bookmanagementsystem.entities;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;


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
    @JsonBackReference(value = "bookAuthor") //indicates that the annotated property (author) should be ignored during serialization to break the cycle
    private Author author;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToMany(mappedBy = "borrowedBooks", fetch = FetchType.EAGER)
    //@JsonIgnore
    private List<Users> profiles = new ArrayList<>();

    public Book(Integer id,  String title, String ISBN, String gener, LocalDate pubYear, Author author) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.gener = gener;
        this.pubYear = pubYear;
        this.author = author;
    }


    @Override
    public String toString(){
        return "Book: "+ " Id: " + id + " title: "+ title + " ISBN: " + ISBN + " pubYear: " + pubYear;
    }

}
