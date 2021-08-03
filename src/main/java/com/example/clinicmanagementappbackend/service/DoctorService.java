package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public List<Doctor> getAll() {
        return doctorRepo.findAll();
    }
}
