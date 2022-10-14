package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    @Override
    @Query("select DISTINCT  patient from Patient patient join fetch patient.reservation ")
    List<Patient> findAll();
}
