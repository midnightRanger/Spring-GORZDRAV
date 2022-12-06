package com.project.GORZDRAV.Repository;

import com.project.GORZDRAV.Models.Passport;
import com.project.GORZDRAV.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Long> {
    public List<Passport> findBySeriesContains(String series);
    public Passport findBySeries(String series);
}
