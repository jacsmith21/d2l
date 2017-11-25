package ca.unb.qualifiers.repository;

import ca.unb.qualifiers.model.Course;
import ca.unb.qualifiers.model.User;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
