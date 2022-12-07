package com.project.GORZDRAV.Models;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 50, message="Длина значения должна быть в диапозоне от 4 до 50")
    private String expectedResult;
    @FutureOrPresent
    private Date start;
    @FutureOrPresent
    private Date end;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private Collection<Result> results = null;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="course_pils",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="pills_id"))
    private List<Pill> pills;

    public Course() {
    }

    public Course(String expectedResult, Date start, Date end, Collection<Result> results, List<Pill> pills) {
        this.expectedResult = expectedResult;
        this.start = start;
        this.end = end;
        this.results = results;
        this.pills = pills;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Collection<Result> getResults() {
        return results;
    }

    public void setResults(Collection<Result> results) {
        this.results = results;
    }

    public List<Pill> getPills() {
        return pills;
    }

    public void setPills(List<Pill> pills) {
        this.pills = pills;
    }
}
