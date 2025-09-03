package mohamed.lak.bookmanagementsystem.services;
import mohamed.lak.bookmanagementsystem.dto.UserDto;
import mohamed.lak.bookmanagementsystem.repositories.UserRepo;
import mohamed.lak.bookmanagementsystem.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    //@Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder PasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserDto toUserDto(Users user) {
        UserDto Udto = new UserDto(
                user.getId_user(),
                user.getUsername(),
                user.getRole(),
                user.getBorrowedDate(),
                user.getBorrowedBooks());
        return Udto;
    }
    public UserDto register(Users user){
        Users u = userRepo.findByUsername(user.getUsername());
        if(u != null) return null;
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        UserDto Udto = toUserDto(user);
        return Udto;
    }
    public List<UserDto> getAllUsers(){
        return userRepo.findAll().stream().map(u->toUserDto(u)).toList();
    }
    public UserDto getUserByName(String name) {
        Users user = userRepo.findByUsername(name);
        if (user == null) return null;
        return toUserDto(user);
    }

}
