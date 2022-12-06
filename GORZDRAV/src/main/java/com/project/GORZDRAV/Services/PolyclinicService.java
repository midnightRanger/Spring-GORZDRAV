package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.MedicalCard;
import com.project.GORZDRAV.Models.Polyclinic;
import com.project.GORZDRAV.Repository.PolyclinicRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PolyclinicService {
    public final PolyclinicRepository polyclinicRepository;

    public PolyclinicService(PolyclinicRepository polyclinicRepository) {
        this.polyclinicRepository = polyclinicRepository;
    }

    public void delete(Polyclinic polyclinic) {
        polyclinicRepository.delete(polyclinic);
    }

    public Optional<Polyclinic> findById(Long id) {
        return polyclinicRepository.findById(id);
    }

    public Polyclinic save(Polyclinic polyclinic) {
        return polyclinicRepository.save(polyclinic);
    }

    public Iterable<Polyclinic> findAll () {
        return polyclinicRepository.findAll();
    }

    public List<Polyclinic> findByNameContains(String name) {
        return polyclinicRepository.findByNameContains(name);
    }
    public Polyclinic findByName(String name) {
        return polyclinicRepository.findByName(name);
    }
}
