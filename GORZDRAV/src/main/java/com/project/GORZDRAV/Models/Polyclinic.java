package com.project.GORZDRAV.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
public class Polyclinic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
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
