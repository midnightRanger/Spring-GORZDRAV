package com.project.GORZDRAV.Models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
public class MedicalProcedure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String description;

    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String name;
    @Min(value=0, message="Значение в поле не может быть меньше 0")
    @Max(value=100000000, message="Значение в поле не может быть больше 100000000")
    private double cost;

    @OneToMany(mappedBy = "medicalProcedure", fetch = FetchType.EAGER)
    private Collection<Record> records = null;

    public MedicalProcedure() {
    }

    public MedicalProcedure(String description, String name, double cost, Collection<Record> records) {
        this.description = description;
        this.name = name;
        this.cost = cost;
        this.records = records;
    }

    public Collection<Record> getRecords() {
        return records;
    }

    public void setRecords(Collection<Record> records) {
        this.records = records;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
