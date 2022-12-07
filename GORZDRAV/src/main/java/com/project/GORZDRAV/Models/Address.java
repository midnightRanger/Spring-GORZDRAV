package com.project.GORZDRAV.Models;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String city;
    private String street;
    private String building;
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
