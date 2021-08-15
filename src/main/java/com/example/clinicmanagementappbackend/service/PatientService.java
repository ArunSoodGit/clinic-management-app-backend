package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Patient;
import com.example.clinicmanagementappbackend.repository.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PatientService {
    private final PatientRepo patientRepo;

    public List<Patient> getAll() {
        return patientRepo.findAll();
    }

    public Optional<Patient> findById(Long patientId) {
        return patientRepo.findById(patientId);
    }

}
