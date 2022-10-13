package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Patient;
import com.example.clinicmanagementappbackend.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;
    private final ObjectMapper objectMapper;

    @Autowired
    public PatientController(PatientService patientService, ObjectMapper objectMapper) {
        this.patientService = patientService;
        this.objectMapper = objectMapper;
    }

    @GetMapping()
    public List<Patient> getPatients() throws JsonProcessingException {
        return patientService.getAll();
    }

    @GetMapping("/{patientsId}")
    public Patient getPatientById(@PathVariable Long patientsId) {
        return patientService.findById(patientsId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + patientsId));
    }

    @PostMapping("")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @DeleteMapping("/{patientId}")
    public void removePatient(@PathVariable Long patientId) {
        patientService.removePatient(patientId);
    }
}
