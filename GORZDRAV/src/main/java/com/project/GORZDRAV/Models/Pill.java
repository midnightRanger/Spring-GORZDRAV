package com.project.GORZDRAV.Models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Pill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String name;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String contra;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String normDay;

    @Min(value = 0, message = "Цена не может быть меньше нуля")
    @Min(value = 100000000, message = "Цена не может быть больше 100000000")
    private double cost;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="course_pils",
            joinColumns = @JoinColumn (name="pills_id"),
            inverseJoinColumns = @JoinColumn(name="course_id"))
    private List<Course> courses;

    public Pill(String name, String contra, String normDay, double cost, List<Course> courses) {
        this.name = name;
        this.contra = contra;
        this.normDay = normDay;
        this.cost = cost;
        this.courses = courses;
    }

    public Pill() {
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNormDay() {
        return normDay;
    }

    public void setNormDay(String normDay) {
        this.normDay = normDay;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
