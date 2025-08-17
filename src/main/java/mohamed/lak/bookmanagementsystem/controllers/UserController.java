package mohamed.lak.bookmanagementsystem.controllers;
import jakarta.servlet.http.HttpServletRequest;
import mohamed.lak.bookmanagementsystem.dto.BookDto;
import mohamed.lak.bookmanagementsystem.dto.UserDto;
import mohamed.lak.bookmanagementsystem.services.UserService;
import mohamed.lak.bookmanagementsystem.entities.Users;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    //@Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getcsrf")
    public CsrfToken generateCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/addNewUser")
    public ResponseEntity<UserDto> register(@RequestBody Users user){
        UserDto Udto = userService.register(user);
        if(Udto == null)return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        return new ResponseEntity<>(Udto, HttpStatus.CREATED);
    }
    @GetMapping("/Users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }
    @GetMapping("/Users/{name}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String name){
        UserDto user =  userService.getUserByName(name);
        if(user == null){return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

}
