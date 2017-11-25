package ca.unb.qualifiers.repository;

import ca.unb.qualifiers.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
