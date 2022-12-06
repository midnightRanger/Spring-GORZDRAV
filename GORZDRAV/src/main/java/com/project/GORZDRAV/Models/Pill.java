package com.project.GORZDRAV.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String name;
    private String contra;
    private String normDay;
    private double cost;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="course_pils",
            joinColumns = @JoinColumn (name="pills_id"),
            inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courses;
}
