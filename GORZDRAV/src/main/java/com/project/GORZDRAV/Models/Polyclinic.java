package com.project.GORZDRAV.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Polyclinic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String name;


    @OneToMany(mappedBy = "polyclinic", fetch = FetchType.EAGER)
    private Collection<MedicalCard> medicalcards = null;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "polyclinicId")
    private Address address;

    @ElementCollection(targetClass = Type.class, fetch = FetchType.EAGER)
    @CollectionTable(name= "polyclinic_type", joinColumns = @JoinColumn(name="polyclinic_id"))
    @Enumerated(EnumType.STRING)
    private Set<Type> types;
}
