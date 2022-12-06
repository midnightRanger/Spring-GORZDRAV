package com.project.GORZDRAV.Repository;

import com.project.GORZDRAV.Models.MedicalCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicalCardRepository extends CrudRepository<MedicalCard, Long> {
    public List<MedicalCard> findBySnilsContains(String snils);
    public MedicalCard findBySnils(String snils);
}
