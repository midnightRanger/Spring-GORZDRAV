package com.project.GORZDRAV.Models;

import javax.persistence.*;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    private String anamnesis;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Course course;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Record record;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Status status;

    public Result() {
    }

    public Result(String anamnesis, Course course, Record record, Status status) {
        this.anamnesis = anamnesis;
        this.course = course;
        this.record = record;
        this.status = status;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
