package com.project.GORZDRAV.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String city;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String street;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String building;
    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String metro;

    @OneToOne(optional = true, mappedBy = "address")
    private Polyclinic polyclinic;

    public Address() {
    }

    public Address(String city, String street, String building, String metro, Polyclinic polyclinic) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.metro = metro;
        this.polyclinic = polyclinic;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public Polyclinic getPolyclinic() {
        return polyclinic;
    }

    public void setPolyclinic(Polyclinic polyclinic) {
        this.polyclinic = polyclinic;
    }
}
