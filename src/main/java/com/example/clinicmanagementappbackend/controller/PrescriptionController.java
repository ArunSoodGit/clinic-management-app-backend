package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.ExceptionMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api")
public class PrescriptionController {

    private final DoctorService doctorService;

    @GetMapping("/prescriptions")
    public List<Doctor> getDoctors() {
        return doctorService.getAll();
    }

    @GetMapping("/prescriptions/{doctorId}")
    public Doctor getDoctorById(@PathVariable Long doctorId) {
        return doctorService.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + doctorId));
    }

    @PostMapping("/prescriptions")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);
    }

    @PutMapping("/prescriptions")
    public void updateDoctor(@RequestBody Doctor doctor) {
        doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/prescriptions/{doctorId}")
    public void removeDoctor(@PathVariable Long doctorId) {
        doctorService.removeDoctor(doctorId);
    }
}
