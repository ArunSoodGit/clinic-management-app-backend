package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
}
