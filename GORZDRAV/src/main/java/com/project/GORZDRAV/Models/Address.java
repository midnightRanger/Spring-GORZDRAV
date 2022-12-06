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
}
