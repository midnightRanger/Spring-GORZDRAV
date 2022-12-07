package com.project.GORZDRAV.Models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class MedicalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @Past
    private Date dateOfTheBirth;
    @Min(value=30, message="Значение в поле не может быть меньше 30")
    @Max(value=120, message="Значение в поле не может быть больше 120")
    private double weight;
    @Min(value=120, message="Значение в поле не может быть меньше 140")
    @Max(value=230, message="Значение в поле не может быть больше 230")
    private double height;


    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{3} \\d{2}$", message = "Формат снилса: 999-999-999 00")
    private String snils;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Polyclinic polyclinic;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "medicalCard", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Record> records = null;

    public MedicalCard() {
    }

    public MedicalCard(Date dateOfTheBirth, double weight, double height, String snils, Polyclinic polyclinic, User user) {
        this.dateOfTheBirth = dateOfTheBirth;
        this.weight = weight;
        this.height = height;
        this.snils = snils;
        this.polyclinic = polyclinic;
        this.user = user;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Date getDateOfTheBirth() {
        return dateOfTheBirth;
    }

    public void setDateOfTheBirth(Date dateOfTheBirth) {
        this.dateOfTheBirth = dateOfTheBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public Polyclinic getPolyclinic() {
        return polyclinic;
    }

    public void setPolyclinic(Polyclinic polyclinic) {
        this.polyclinic = polyclinic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
