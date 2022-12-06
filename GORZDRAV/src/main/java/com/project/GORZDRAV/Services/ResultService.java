package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.MedicalProcedure;
import com.project.GORZDRAV.Models.Result;
import com.project.GORZDRAV.Repository.ProcedureRepository;
import com.project.GORZDRAV.Repository.ResultRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ResultService {
    public final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public void delete(Result result) {
        resultRepository.delete(result);
    }

    public Optional<Result> findById(Long id) {
        return resultRepository.findById(id);
    }

    public Result save(Result result) {
        return resultRepository.save(result);
    }

    public Iterable<Result> findAll () {
        return resultRepository.findAll();
    }

    public List<Result> findByAnamnesisContains(String anamnesis) {
        return resultRepository.findByAnamnesisContains(anamnesis);
    }
}
