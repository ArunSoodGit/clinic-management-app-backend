package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {
}
