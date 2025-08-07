package mohamed.lak.bookmanagementsystem.security;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<user, Integer> {
    user findByUsername(String username);
}
