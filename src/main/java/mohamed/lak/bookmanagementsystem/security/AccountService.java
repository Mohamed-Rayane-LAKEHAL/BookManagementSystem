package mohamed.lak.bookmanagementsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder ;

    public user addUser(String username, String password, String role) {
        user user  =userRepo.findByUsername(username);
        if (user != null) throw new RuntimeException("This user already exists");
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        return userRepo.save(user);
    }

    public user loadUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

}
