package mohamed.lak.bookmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    @Column(unique=true, nullable=false)
    private String username;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private String Role;

    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private UserProfile profile;

    @Override
    public String toString(){
        return "User: " + "Id: " + id_user + " Name: " + username + " Role: " + Role;
    }
}