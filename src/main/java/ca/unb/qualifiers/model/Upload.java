package ca.unb.qualifiers.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Date date;

    @Column(length=2147483647)
    private byte[] data;

    @ManyToOne
    private User student;

    @ManyToOne
    private Deliverable deliverable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExtension() {
        return name.substring(name.indexOf("."));
    }
}
