package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.MedicalCard;
import com.project.GORZDRAV.Models.Status;
import com.project.GORZDRAV.Repository.MedicalCardRepository;
import com.project.GORZDRAV.Repository.StatusRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatusService {

    public final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void delete(Status status) {
        statusRepository.delete(status);
    }

    public Optional<Status> findById(Long id) {
        return statusRepository.findById(id);
    }

    public Status save(Status status) {
        return statusRepository.save(status);
    }

    public Iterable<Status> findAll () {
        return statusRepository.findAll();
    }

    public List<Status> findByFinalConclusionContains(String finalConclusion) {
        return statusRepository.findByFinalConclusionContains(finalConclusion);
    }
    public Status findByFinalConclusion(String finalConclusion) {
        return statusRepository.findByFinalConclusion(finalConclusion);
    }
}
