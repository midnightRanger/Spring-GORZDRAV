package com.project.GORZDRAV.Services;

import com.project.GORZDRAV.Models.Record;
import com.project.GORZDRAV.Repository.RecordRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecordService {

    public final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public void delete(Record record) {
        recordRepository.delete(record);
    }

    public Optional<Record> findById(Long id) {
        return recordRepository.findById(id);
    }

    public Record save(Record record) {
        return recordRepository.save(record);
    }

    public Iterable<Record> findAll () {
        return recordRepository.findAll();
    }

    public List<Record> findByComplaintContains(String complaint) {
        return recordRepository.findByComplaintContains(complaint);
    }
    public Record findByComplaint(String complaint) {
        return recordRepository.findByComplaint(complaint);
    }
}
