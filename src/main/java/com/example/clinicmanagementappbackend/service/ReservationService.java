package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Patient;
import com.example.clinicmanagementappbackend.model.Reservation;
import com.example.clinicmanagementappbackend.repository.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ReservationService {

    private final ReservationRepo reservationRepo;


    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    public Optional<Reservation> findReservationById(Long reservationId) {
        return reservationRepo.findById(reservationId);
    }

    public void addReservation(Reservation reservation) {
        reservationRepo.save(reservation);
    }

    public void updateReservation(Reservation reservation) {
        if (reservationRepo.existsById(reservation.getId())) {
            reservationRepo.save(reservation);
        }
    }

    public void removeReservation(Long reservationId) {
        if (reservationRepo.existsById(reservationId)) {
            reservationRepo.deleteById(reservationId);
        }
    }

    public List<Reservation> findAllByDoctor(Long doctorId) {
        return reservationRepo.findAllByDoctorId(doctorId);
    }
    public List<Reservation> findAllByPatient(Long patientId) {
        return reservationRepo.findAllByPatientId(patientId);
    }

}
