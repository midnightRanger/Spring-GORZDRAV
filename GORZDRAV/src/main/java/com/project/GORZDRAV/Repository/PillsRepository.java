package com.project.GORZDRAV.Repository;

import com.project.GORZDRAV.Models.Pill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PillsRepository extends CrudRepository<Pill, Long> {

    public List<Pill> findByNameContains(String name);
    public Pill findByName(String name);
}
