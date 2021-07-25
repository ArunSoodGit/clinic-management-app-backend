package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Long> {
}
