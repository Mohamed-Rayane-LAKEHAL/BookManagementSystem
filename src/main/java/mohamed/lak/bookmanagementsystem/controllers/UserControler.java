package mohamed.lak.bookmanagementsystem.controllers;
import mohamed.lak.bookmanagementsystem.services.UserService;
import mohamed.lak.bookmanagementsystem.security.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControler {

    @Autowired
    private UserService userService;
    @PostMapping("/addNewUser")
    public user Register(user user){
        return userService.Register(user);
    }

}
