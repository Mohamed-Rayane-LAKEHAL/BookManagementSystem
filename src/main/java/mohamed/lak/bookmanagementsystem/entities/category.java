package mohamed.lak.bookmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Book> books = new ArrayList<>();

    public String ToString(){
        return "Category: "+ " Id: " + id + " name: "+ name ;
    }

}
