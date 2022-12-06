package com.project.GORZDRAV.Repository;

import com.project.GORZDRAV.Models.Course;
import com.project.GORZDRAV.Models.MedicalCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    public List<Course> findByExpectedResultContains(String result);
    public Course findByExpectedResult(String result);
}
