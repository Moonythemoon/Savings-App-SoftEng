package com.example.savings.repository;

import com.example.savings.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<Saving, Long> {
    Saving findByCustomerNumber(int customerNumber);
}
