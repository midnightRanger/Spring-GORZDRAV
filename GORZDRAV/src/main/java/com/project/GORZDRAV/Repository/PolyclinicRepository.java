package com.project.GORZDRAV.Repository;

import com.project.GORZDRAV.Models.Passport;
import com.project.GORZDRAV.Models.Polyclinic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PolyclinicRepository extends CrudRepository<Polyclinic, Long> {
    public Polyclinic findByName(String name);
    public List<Polyclinic> findByNameContains(String name);
}
