package org.example.record.repository;

import org.example.record.entity.BookRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRecordRepository extends JpaRepository<BookRecord, Integer> {
}
