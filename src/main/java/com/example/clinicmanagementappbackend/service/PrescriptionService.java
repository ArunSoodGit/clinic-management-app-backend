package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.Prescription;
import com.example.clinicmanagementappbackend.model.Reservation;
import com.example.clinicmanagementappbackend.repository.PrescriptionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PrescriptionService {

    private final PrescriptionRepo prescriptionRepo;

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepo.findAll();
    }

    public Optional<Prescription> findPrescriptionById(Long prescriptionId) {
        return prescriptionRepo.findById(prescriptionId);
    }

    public void addPrescription(Prescription prescription) {
        prescriptionRepo.save(prescription);
    }

    public void updatePrescription(Prescription prescription) {
        if (prescriptionRepo.existsById(prescription.getId())) {
            prescriptionRepo.save(prescription);
        }
    }

    public void removePrescription(Long prescriptionId) {
        if (prescriptionRepo.existsById(prescriptionId)) {
            prescriptionRepo.deleteById(prescriptionId);
        }
    }

    public Prescription getPrescriptionForReservation(Reservation reservation) {
        return prescriptionRepo.getPrescriptionByReservationId(reservation.getId()).orElse(new Prescription());
    }

}
