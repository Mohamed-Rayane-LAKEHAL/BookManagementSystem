package mohamed.lak.bookmanagementsystem.services;
import mohamed.lak.bookmanagementsystem.repositories.UserRepo;
import mohamed.lak.bookmanagementsystem.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder();

    public void register(Users user){
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

}
