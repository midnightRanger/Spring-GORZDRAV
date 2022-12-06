package com.project.GORZDRAV.Repository;

import com.project.GORZDRAV.Models.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {
    public List<Result> findByAnamnesisContains(String anamnesis);
}
