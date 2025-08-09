package mohamed.lak.bookmanagementsystem.services;
import mohamed.lak.bookmanagementsystem.security.userRepo;
import mohamed.lak.bookmanagementsystem.security.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private userRepo userRepo;
    private BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder();

    public void Register(user user){
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

}
