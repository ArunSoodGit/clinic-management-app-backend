package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Prescription;
import com.example.clinicmanagementappbackend.model.Reservation;
import com.example.clinicmanagementappbackend.repository.PrescriptionRepo;
import com.example.clinicmanagementappbackend.repository.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PrescriptionService {

    private final PrescriptionRepo prescriptionRepo;


    public List<Prescription> getAllReservations() {
        return prescriptionRepo.findAll();
    }

    public Optional<Prescription> findReservationById(Long reservationId) {
        return prescriptionRepo.findById(reservationId);
    }

    public void addReservation(Prescription reservation) {
        prescriptionRepo.save(reservation);
    }

    public void updateReservation(Prescription reservation) {
        if (prescriptionRepo.existsById(reservation.getId())) {
            prescriptionRepo.save(reservation);
        }
    }

    public void removeReservation(Long reservationId) {
        if (prescriptionRepo.existsById(reservationId)) {
            prescriptionRepo.deleteById(reservationId);
        }
    }

}
