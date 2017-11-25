package ca.unb.qualifiers.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String section;

    @ManyToMany(mappedBy = "enrolledCourses")
    private List<User> students;

    @ManyToOne
    private User instructor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
