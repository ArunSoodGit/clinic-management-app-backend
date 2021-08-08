package com.example.clinicmanagementappbackend.controller;
import com.example.clinicmanagementappbackend.model.Prescription;
import com.example.clinicmanagementappbackend.model.Reservation;
import com.example.clinicmanagementappbackend.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @GetMapping("/prescriptions")
    public List<Prescription> getPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("/prescriptions/{prescriptionId}")
    public Prescription getPrescriptionById(@PathVariable Long prescriptionId) {
        return prescriptionService.findPrescriptionById(prescriptionId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + prescriptionId));
    }

    @PostMapping("/prescriptions")
    public void addPrescription(@RequestBody Prescription prescription) {
        prescriptionService.addPrescription(prescription);
    }

    @PutMapping("/prescriptions")
    public void updatePrescription(@RequestBody Prescription prescription) {
        prescriptionService.updatePrescription(prescription);
    }

    @DeleteMapping("/prescriptions/{prescriptionId}")
    public void removePrescription(@PathVariable Long prescriptionId) {
        prescriptionService.removePrescription(prescriptionId);
    }

    @PostMapping("/reservations/prescriptions")
    public Prescription getPrescriptionForReservation(@RequestBody Reservation reservation) {
       return prescriptionService.getPrescriptionForReservation(reservation);
    }
}
