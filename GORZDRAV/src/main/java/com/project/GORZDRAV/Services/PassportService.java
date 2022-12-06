package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.Passport;
import com.project.GORZDRAV.Models.User;
import com.project.GORZDRAV.Repository.PassportRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PassportService {
    public final PassportRepository passportRepository;

    public PassportService(PassportRepository passportRepositoryRepository) {
        this.passportRepository = passportRepositoryRepository;
    }
    public void delete(Passport passportObj) {
        passportRepository.delete(passportObj);
    }

    public Optional<Passport> findById(Long id) {
        return passportRepository.findById(id);
    }

    public Passport save(Passport passportObj) {
        return passportRepository.save(passportObj);
    }

    public Iterable<Passport> findAll () {
        return passportRepository.findAll();
    }

    public List<Passport> findBySeriesContains(String series) {
        return passportRepository.findBySeriesContains(series);
    }

    public Passport findBySeries(String series) {return passportRepository.findBySeries(series); }
}
