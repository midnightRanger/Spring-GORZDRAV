package com.project.GORZDRAV.Repository;
import com.project.GORZDRAV.Models.Record;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepository extends CrudRepository<Record, Long> {
    public List<Record> findByComplaintContains(String complaint);
    public Record findByComplaint(String complaint);
}
