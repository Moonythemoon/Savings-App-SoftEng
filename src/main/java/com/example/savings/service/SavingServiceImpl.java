package com.example.savings.service;

import com.example.savings.model.Saving;
import com.example.savings.repository.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingServiceImpl implements SavingService {

    @Autowired
    private SavingRepository savingRepository;

    @Override
    public List<Saving> findAll() {
        return savingRepository.findAll();
    }

    @Override
    public Saving findByCustomerNumber(int customerNumber) {
        return savingRepository.findByCustomerNumber(customerNumber);
    }

    @Override
    public Saving save(Saving saving) {
        return savingRepository.save(saving);
    }

    @Override
    public void deleteById(Long id) {
        savingRepository.deleteById(id);
    }

    @Override
    public Optional<Saving> findById(Long id) {  // Add this method
        return savingRepository.findById(id);
    }
}
