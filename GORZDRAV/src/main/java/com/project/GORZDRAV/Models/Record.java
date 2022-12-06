package com.project.GORZDRAV.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private Date date;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private User patient;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private User doctor;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private MedicalCard medicalCard;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private MedicalProcedure medicalProcedure;


    private String complaint;

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
}
