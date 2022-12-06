package com.project.GORZDRAV.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private Date start;
    private Date end;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="course_pils",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="pills_id"))
    private List<Pill> pills;
}
