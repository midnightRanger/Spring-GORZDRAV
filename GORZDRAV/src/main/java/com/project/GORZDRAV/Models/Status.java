package com.project.GORZDRAV.Models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @NotNull(message = "Поле не может быть пустым")
    @Min(value=50, message="Значение в поле не может быть меньше 50")
    @Max(value=200, message="Значение в поле не может быть больше 200 (Пациент умер от инсульта)")
    private double systolic;

    @NotNull(message = "Поле не может быть пустым")
    @Min(value=40, message="Значение в поле не может быть меньше 40")
    @Max(value=120, message="Значение в поле не может быть больше 120 ")
    private double diastolic;

    @NotNull(message = "Поле не может быть пустым")
    @Min(value=40, message="Значение в поле не может быть меньше 40")
    @Max(value=200, message="Значение в поле не может быть больше 200")
    private double pulse;

    @NotBlank
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
    private String eyes;

    @NotBlank(message="Данное поле не может состоять из пробелов")
    @NotEmpty(message= "Данное поле не может быть пустым")
    @Size(min = 4, max = 255, message="Длина значения должна быть в диапозоне от 4 до 255")
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
