package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.MedicalProcedure;
import com.project.GORZDRAV.Repository.ProcedureRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProcedureService {


    public final ProcedureRepository procedureRepository;

    public ProcedureService(ProcedureRepository procedureRepository) {
        this.procedureRepository = procedureRepository;
    }

    public void delete(MedicalProcedure medicalProcedure) {
        procedureRepository.delete(medicalProcedure);
    }

    public Optional<MedicalProcedure> findById(Long id) {
        return procedureRepository.findById(id);
    }

    public MedicalProcedure save(MedicalProcedure medicalProcedure) {
        return procedureRepository.save(medicalProcedure);
    }

    public Iterable<MedicalProcedure> findAll () {
        return procedureRepository.findAll();
    }

    public List<MedicalProcedure> findByNameContains(String name) {
        return procedureRepository.findByNameContains(name);
    }
    public MedicalProcedure findByName(String name) {
        return procedureRepository.findByName(name);
    }
}
