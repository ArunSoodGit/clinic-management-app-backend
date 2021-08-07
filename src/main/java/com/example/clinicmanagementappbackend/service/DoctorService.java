package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class DoctorService {

    private final DoctorRepo doctorRepo;

    public List<Doctor> getAll() {
        return doctorRepo.findAll();
    }

    public Optional<Doctor> findById(Long doctorId) {
        return doctorRepo.findById(doctorId);
    }

    public void addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        if (doctorRepo.existsById(doctor.getId())) {
            doctorRepo.save(doctor);
        }
    }

    public void removeDoctor(Long doctorId) {
        if (doctorRepo.existsById(doctorId)) {
            doctorRepo.deleteById(doctorId);
        }
    }
}
