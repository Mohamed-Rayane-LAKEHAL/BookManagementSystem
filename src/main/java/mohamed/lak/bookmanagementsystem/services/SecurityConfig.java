package mohamed.lak.bookmanagementsystem.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();


    }



}
















//https://www.youtube.com/watch?v=her_7pa0vrg&t=2404s
// https://www.youtube.com/results?search_query=spring+security+%D8%B4%D8%B1%D8%AD
// https://www.youtube.com/watch?v=nSu9ElsnNtY&list=PLEocw3gLFc8X_a8hGWGaBnSkPFJmbb8QP&index=2
//https://www.marcobehler.com/guides/spring-security-oauth2
// https://www.marcobehler.com/guides/spring-security
