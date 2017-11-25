package ca.unb.qualifiers.validator;

import ca.unb.qualifiers.model.Course;
import ca.unb.qualifiers.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import ca.unb.qualifiers.model.Course;
import ca.unb.qualifiers.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CourseValidator implements Validator {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Course.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Course course = (Course) o;

        if (course.getId() == null && !courseRepository.findByInstructorUsernameAndNameAndSection(course.getInstructor().getUsername(), course.getName(), course.getSection()).isEmpty()) {
            errors.rejectValue("name", "This section for this course already exists.");
        }

        if (course.getName() == null || course.getName().isEmpty()) {
            errors.rejectValue("name", "Ensure all required fields are filled. (Check Course Name)");
        } else if (course.getName().length() > 10) {
            errors.rejectValue("name", "Course name should be less than 10 characters");
        }

        if (course.getSection() != null && course.getSection().length() > 10) {
            errors.rejectValue("section", "Section should be less than 10 characters");
        }
    }
}
