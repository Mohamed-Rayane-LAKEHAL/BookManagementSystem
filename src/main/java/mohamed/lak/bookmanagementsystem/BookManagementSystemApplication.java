package mohamed.lak.bookmanagementsystem;

//import mohamed.lak.bookmanagementsystem.security.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BookManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementSystemApplication.class, args);
	}




//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}


}
