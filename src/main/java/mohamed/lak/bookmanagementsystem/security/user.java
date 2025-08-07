package mohamed.lak.bookmanagementsystem.security;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mohamed.lak.bookmanagementsystem.entities.Book;
import mohamed.lak.bookmanagementsystem.entities.userProfile;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class user implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true, nullable=false)
    private String username;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private String Role;

    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private userProfile profile;

    public String ToString(){
        return "User: " + "Id: " + id + " Name: " + username + " Role: " + Role;
    }

}