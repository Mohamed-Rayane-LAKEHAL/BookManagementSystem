package mohamed.lak.bookmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id_user;
    @Column(unique=true, nullable=false)
    private String username;
    @Column(nullable=false)
    private String password;
    @Temporal(TemporalType.DATE)
    private LocalDate borrowedDate;
    @Column(nullable=false)
    private String Role;
    @ManyToMany()
    @JoinTable(name = "user_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> borrowedBooks = new ArrayList<>();

    @Override
    public String toString(){
        return "User: " + "Id: " + id_user + " Name: " + username ;
    }
}