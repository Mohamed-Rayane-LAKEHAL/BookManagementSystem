package mohamed.lak.bookmanagementsystem.controllers;
import mohamed.lak.bookmanagementsystem.services.UserService;
import mohamed.lak.bookmanagementsystem.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addNewUser")
    public void register(@RequestBody Users user){
        userService.register(user);
    }



}
