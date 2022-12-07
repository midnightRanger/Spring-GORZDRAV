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
    @JoinColumn(name = "addressId")
    private Address address;

    @ElementCollection(targetClass = Type.class, fetch = FetchType.EAGER)
    @CollectionTable(name= "polyclinic_type", joinColumns = @JoinColumn(name="polyclinic_id"))
    @Enumerated(EnumType.STRING)
    private Set<Type> types;

    public Polyclinic() {

    }

    public Polyclinic(String name, Collection<MedicalCard> medicalcards, Address address, Set<Type> types) {
        this.name = name;
        this.medicalcards = medicalcards;
        this.address = address;
        this.types = types;
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

    public Collection<MedicalCard> getMedicalcards() {
        return medicalcards;
    }

    public void setMedicalcards(Collection<MedicalCard> medicalcards) {
        this.medicalcards = medicalcards;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }
}
