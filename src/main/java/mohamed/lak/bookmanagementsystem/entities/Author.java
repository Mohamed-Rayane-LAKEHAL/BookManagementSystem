package mohamed.lak.bookmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(length = 100)
    private String Bibliography;
    private String Nationality;

    public Author(Integer id, String name, String Bibliography, String Nationality) {
        this.id = id;
        this.name = name;
        this.Bibliography = Bibliography;
        this.Nationality = Nationality;
    } // this constructor is created only due to unit testing

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "bookAuthor") // indicates that the annotated property (book) should be included in the JSON output during serialization.
    private List<Book> books = new ArrayList<>() ;

    @Override
    public String toString() {
        return "id " + id + " name "+ name+ " Bibliography "+ Bibliography + " Nationality " + Nationality;
    }




}
