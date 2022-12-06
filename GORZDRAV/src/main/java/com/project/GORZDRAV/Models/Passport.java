package com.project.GORZDRAV.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String series;
    private String number;
    private Date given;

    @OneToOne(optional = true, mappedBy = "passport")
    private User passportOwner;

    public Passport() {
    }

    public Passport(String series, String number, Date given, User passportOwner) {
        this.series = series;
        this.number = number;
        this.given = given;
        this.passportOwner = passportOwner;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getGiven() {
        return given;
    }

    public void setGiven(Date given) {
        this.given = given;
    }

    public User getPassportOwner() {
        return passportOwner;
    }

    public void setPassportOwner(User passportOwner) {
        this.passportOwner = passportOwner;
    }
}
