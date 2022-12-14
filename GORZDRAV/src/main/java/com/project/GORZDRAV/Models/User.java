package com.project.GORZDRAV.Models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 50, message="Длина значения должна быть в диапозоне от 4 до 50")
    private String username;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 5, max = 2000, message="Длина пароля должна быть в диапозоне от 5 до 50")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{5,}$", message = "Проверьте пароль " +
            "на соответствие требованиям: \n1) Наличие хотя бы одной цифры" +
            "\n2) Наличие хотя бы одной строчной буквы" +
            "\n3) Наличие хотя бы одной заглавной буквы" +
            "\n4) Наличие спец. символа - @#$%^&+=" +
            "\n5) Длина - от 5 до 50 символов")
    private String password;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 2, max = 50, message="Длина значения должна быть в диапозоне от 2 до 50")
    private String name;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 50, message="Длина значения должна быть в диапозоне от 4 до 50")
    private String surname;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 50, message="Длина значения должна быть в диапозоне от 4 до 50")
    private String middlename;

    @OneToOne(optional = true, mappedBy = "user")
    private MedicalCard medicalCard;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name= "user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "passportId")
    private Passport passport;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<Record> records = null;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private Collection<Record> recordsDoctor = null;

    public User() {
    }

    public User(String username, String password, String name, String surname, String middlename, MedicalCard medicalCard, boolean active, Set<Role> roles, Passport passport) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.medicalCard = medicalCard;
        this.active = active;
        this.roles = roles;
        this.passport = passport;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Set<Role> getRoles() {
        return roles;
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public MedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }
}