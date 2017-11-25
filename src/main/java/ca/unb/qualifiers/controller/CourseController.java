package ca.unb.qualifiers.controller;

import ca.unb.qualifiers.model.Course;
import ca.unb.qualifiers.model.Deliverable;
import ca.unb.qualifiers.model.Upload;
import ca.unb.qualifiers.model.User;
import ca.unb.qualifiers.repository.CourseRepository;
import ca.unb.qualifiers.repository.DeliverableRepository;
import ca.unb.qualifiers.repository.UploadRepository;
import ca.unb.qualifiers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    DeliverableRepository deliverableRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UploadRepository uploadRepository;

    @GetMapping("/courses")
    @ResponseBody
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{username}/{coursename}")
    public String dashboard(ModelMap map, Principal principal, @PathVariable String username, @PathVariable String coursename) {
        if (!principal.getName().equals(username)) {
            return "404";
        }

        User user = userRepository.findByUsername(username);
        Course course = courseRepository.findByName(coursename);
        List<Deliverable> deliverables = deliverableRepository.findByCourse(course);

        map.addAttribute("deliverables", deliverables);
        map.addAttribute("user", user);

        if(user.isInstructor()) {
            List<Upload> uploads = new LinkedList<>();
            for(Deliverable deliverable : deliverables)
                uploads.addAll(deliverable.getUploads());
            map.addAttribute("uploads", uploads);
        }

        return "course";
    }
}
