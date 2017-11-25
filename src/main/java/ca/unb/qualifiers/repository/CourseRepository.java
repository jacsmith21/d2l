package ca.unb.qualifiers.repository;

import ca.unb.qualifiers.model.Course;
import ca.unb.qualifiers.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    List<Course> findByInstructorUsernameAndNameAndSection(String username, String name, String section);
}
