package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Patient;
import com.example.clinicmanagementappbackend.model.Room;
import com.example.clinicmanagementappbackend.model.Specialization;
import com.example.clinicmanagementappbackend.service.DoctorService;
import com.example.clinicmanagementappbackend.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;
    private final ObjectMapper objectMapper;

    @GetMapping("/patients")
    public String getPatients() throws JsonProcessingException {
        List<Patient> doctorList = patientService.getAll();
        return objectMapper.writeValueAsString(doctorList);
    }
    @GetMapping("/patients/{patientsId}")
    public Patient getPatientById(@PathVariable Long patientsId) {
        return patientService.findById(patientsId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + patientsId));
    }


    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @DeleteMapping("/patients/{patientId}")
    public void removePatient(@PathVariable Long patientId) {

        patientService.removePatient(patientId);
    }
}
