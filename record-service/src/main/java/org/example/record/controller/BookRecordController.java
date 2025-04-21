package org.example.record.controller;

import org.example.record.entity.BookRecord;
import org.example.record.repository.BookRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/records")
public class BookRecordController {

    @Autowired
    private BookRecordRepository bookRecordRepository;

    @GetMapping
    public List<BookRecord> getAllRecords() {
        return bookRecordRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BookRecord> getRecordById(@PathVariable Integer id) {
        return bookRecordRepository.findById(id);
    }

    @PostMapping
    public BookRecord createRecord(@RequestBody BookRecord record) {
        return bookRecordRepository.save(record);
    }

    @PutMapping("/{id}")
    public BookRecord updateRecord(@PathVariable Integer id, @RequestBody BookRecord recordDetails) {
        return bookRecordRepository.findById(id).map(record -> {
            record.setBook(recordDetails.getBook());
            record.setGetTime(recordDetails.getGetTime());
            record.setAvailability(recordDetails.getAvailability());
            record.setUserId(recordDetails.getUserId());
            return bookRecordRepository.save(record);
        }).orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable Integer id) {
        bookRecordRepository.deleteById(id);
    }
}
