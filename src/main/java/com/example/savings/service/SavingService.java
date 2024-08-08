package com.example.savings.service;

import com.example.savings.model.Saving;

import java.util.List;
import java.util.Optional;

public interface SavingService {
    List<Saving> findAll();
    Saving findByCustomerNumber(int customerNumber);
    Saving save(Saving saving);
    void deleteById(Long id);
    Optional<Saving> findById(Long id);  // Add this line
}
