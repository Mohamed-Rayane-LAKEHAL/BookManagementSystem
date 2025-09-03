package mohamed.lak.bookmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
public class Category implements Serializable {
    public Category(String name){
        this.name = name;
    }
    public Category(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString(){
        return "Category: "+ " Id: " + id + " name: "+ name ;
    }

}
