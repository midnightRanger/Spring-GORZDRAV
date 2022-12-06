package com.project.GORZDRAV.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private double systolic;
    private double diastrolic;
    private double pulse;
    private String eyes;

    private String finalConclusion;

    public Status() {
    }

    public Status(double systolic, double diastrolic, double pulse, String eyes, String finalConclusion) {
        this.systolic = systolic;
        this.diastrolic = diastrolic;
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

    public double getDiastrolic() {
        return diastrolic;
    }

    public void setDiastrolic(double diastrolic) {
        this.diastrolic = diastrolic;
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
