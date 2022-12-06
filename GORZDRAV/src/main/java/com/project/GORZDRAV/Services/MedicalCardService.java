package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.MedicalCard;
import com.project.GORZDRAV.Repository.MedicalCardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicalCardService {

    public final MedicalCardRepository medicalCardRepository;

    public MedicalCardService(MedicalCardRepository medicalCardRepository) {
        this.medicalCardRepository = medicalCardRepository;
    }

    public void delete(MedicalCard medicalCard) {
        medicalCardRepository.delete(medicalCard);
    }

    public Optional<MedicalCard> findById(Long id) {
        return medicalCardRepository.findById(id);
    }

    public MedicalCard save(MedicalCard medicalCard) {
        return medicalCardRepository.save(medicalCard);
    }

    public Iterable<MedicalCard> findAll () {
        return medicalCardRepository.findAll();
    }

    public List<MedicalCard> findBySnilsContains(String snils) {
        return medicalCardRepository.findBySnilsContains(snils);
    }
}
