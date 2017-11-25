package ca.unb.qualifiers.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String username;
    private boolean instructor;
    private String password;

    @Transient
    private String passwordConfirm;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Course> createdCourses;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Course> enrolledCourses;

    @OneToMany(mappedBy = "student")
    private List<Upload> uploads;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isInstructor() {
        return instructor;
    }

    public void isInstructor(Boolean instructor) {
        this.instructor = instructor;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public List<Course> getCreatedCourses() {
        return createdCourses;
    }

    public void setCreatedCourses(List<Course> createdCourses) {
        this.createdCourses = createdCourses;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public boolean inCourse(Course course) {
        if(enrolledCourses == null) {
            return false;
        }

        for(Course c : enrolledCourses) {
            if(c.getId().equals(course.getId())) {
                return true;
            }
        }

        return false;
    }
}
