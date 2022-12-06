package com.project.GORZDRAV.Repository;

import com.project.GORZDRAV.Models.MedicalProcedure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcedureRepository extends CrudRepository<MedicalProcedure, Long> {

    public List<MedicalProcedure> findByNameContains(String name);
    public MedicalProcedure findByName(String name);
}
