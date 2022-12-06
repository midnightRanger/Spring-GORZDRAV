package com.project.GORZDRAV.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private double systolic;
    private double diastolic;
    private double pulse;
    private String eyes;

    private String finalConclusion;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private Collection<Result> results = null;

    public Status() {
    }

    public Status(double systolic, double diastolic, double pulse, String eyes, String finalConclusion) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.pulse = pulse;
        this.eyes = eyes;
        this.finalConclusion = finalConclusion;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public double getSystolic() {
        return systolic;
    }

    public void setSystolic(double systolic) {
        this.systolic = systolic;
    }

    public double getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(double diastolic) {
        this.diastolic = diastolic;
    }

    public double getPulse() {
        return pulse;
    }

    public void setPulse(double pulse) {
        this.pulse = pulse;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getFinalConclusion() {
        return finalConclusion;
    }

    public void setFinalConclusion(String finalConclusion) {
        this.finalConclusion = finalConclusion;
    }
}
