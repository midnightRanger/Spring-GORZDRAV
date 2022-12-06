package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.Course;
import com.project.GORZDRAV.Models.Result;
import com.project.GORZDRAV.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {
    public final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void delete(Course course) {
        courseRepository.delete(course);
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public Iterable<Course> findAll () {
        return courseRepository.findAll();
    }

    public List<Course> findByExpectedResultContains(String expectedResult) {
        return courseRepository.findByExpectedResultContains(expectedResult);
    }

    public Course findByExpectedResult(String result) {
        return courseRepository.findByExpectedResult(result);
    }
}
