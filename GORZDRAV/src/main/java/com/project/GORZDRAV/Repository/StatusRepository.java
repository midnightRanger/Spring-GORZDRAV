package com.project.GORZDRAV.Repository;

import com.project.GORZDRAV.Models.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRepository extends CrudRepository<Status, Long> {

    public List<Status> findByFinalConclusionContains(String finalConclusion);
    public Status findByFinalConclusion(String finalConclusion);
}
