package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.Pill;
import com.project.GORZDRAV.Models.Polyclinic;
import com.project.GORZDRAV.Repository.PillsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PillService {

    public final PillsRepository pillsRepository;

    public PillService(PillsRepository pillsRepository) {
        this.pillsRepository = pillsRepository;
    }

    public void delete(Pill pill) {
        pillsRepository.delete(pill);
    }

    public Optional<Pill> findById(Long id) {
        return pillsRepository.findById(id);
    }

    public Pill save(Pill pill) {
        return pillsRepository.save(pill);
    }

    public Iterable<Pill> findAll () {
        return pillsRepository.findAll();
    }

    public List<Pill> findByNameContains(String name) {
        return pillsRepository.findByNameContains(name);
    }
    public Pill findByName(String name) {
        return pillsRepository.findByName(name);
    }
}
