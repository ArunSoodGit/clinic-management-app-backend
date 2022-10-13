package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Prescription;
import com.example.clinicmanagementappbackend.model.Reservation;
import com.example.clinicmanagementappbackend.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping()
    public List<Prescription> getPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/{prescriptionId}")
    public Prescription getPrescriptionById(@PathVariable Long prescriptionId) {
        return prescriptionService.findPrescriptionById(prescriptionId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + prescriptionId));
    }

    @PostMapping("")
    public void addPrescription(@RequestBody Prescription prescription) {
        prescriptionService.addPrescription(prescription);
    }

    @PutMapping("")
    public void updatePrescription(@RequestBody Prescription prescription) {
        prescriptionService.updatePrescription(prescription);
    }

    @DeleteMapping("/{prescriptionId}")
    public void removePrescription(@PathVariable Long prescriptionId) {
        prescriptionService.removePrescription(prescriptionId);
    }

    @PostMapping("/reservations")
    public Prescription getPrescriptionForReservation(@RequestBody Reservation reservation) {
        return prescriptionService.getPrescriptionForReservation(reservation);
    }
}
