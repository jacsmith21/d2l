package ca.unb.qualifiers.repository;

import ca.unb.qualifiers.model.Course;
import ca.unb.qualifiers.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
