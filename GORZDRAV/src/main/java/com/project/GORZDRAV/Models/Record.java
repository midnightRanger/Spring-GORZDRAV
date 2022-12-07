package com.project.GORZDRAV.Models;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @FutureOrPresent(message = "Время записи не может быть прошедшим!")
    private Date date;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private User patient;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private User doctor;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private MedicalCard medicalCard;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private MedicalProcedure medicalProcedure;

    @OneToMany(mappedBy = "record", fetch = FetchType.LAZY)
    private Collection<Result> results = null;

    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String complaint;

    private boolean isOpened;

    public Record() {
    }

    public Record(Date date, User patient, User doctor, MedicalCard medicalCard, MedicalProcedure medicalProcedure, String complaint) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.medicalCard = medicalCard;
        this.medicalProcedure = medicalProcedure;
        this.complaint = complaint;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public MedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }

    public MedicalProcedure getProcedure() {
        return medicalProcedure;
    }

    public void setProcedure(MedicalProcedure medicalProcedure) {
        this.medicalProcedure = medicalProcedure;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public Collection<Result> getResults() {
        return results;
    }

    public void setResults(Collection<Result> results) {
        this.results = results;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }
}
