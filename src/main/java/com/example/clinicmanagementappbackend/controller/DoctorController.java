package com.example.clinicmanagementappbackend.controller;
import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.service.DoctorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api")
public class DoctorController {

    private final DoctorService doctorService;
    private final ObjectMapper objectMapper;

    @GetMapping("/doctors")
    public String getDoctors() throws JsonProcessingException {
        List<Doctor> doctorList = doctorService.getAll();
        return objectMapper.writeValueAsString(doctorList);
    }

    @GetMapping("/doctors/{doctorId}")
    public Doctor getDoctorById(@PathVariable Long doctorId) {
        return doctorService.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + doctorId));
    }

    @PostMapping("/doctors")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);
    }

    @PutMapping("/doctors")
    public void updateDoctor(@RequestBody Doctor doctor) {
        doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/doctors/{doctorId}")
    public void removeDoctor(@PathVariable Long doctorId) {
        doctorService.removeDoctor(doctorId);
    }
}
