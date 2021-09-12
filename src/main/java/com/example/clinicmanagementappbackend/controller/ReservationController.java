package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Patient;
import com.example.clinicmanagementappbackend.model.Prescription;
import com.example.clinicmanagementappbackend.model.Reservation;
import com.example.clinicmanagementappbackend.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservations/{reservationId}")
    public Reservation getReservationById(@PathVariable Long reservationId) {
        return reservationService.findReservationById(reservationId).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/reservations")
    public void addReservation(@RequestBody Reservation reservation) {
        if (reservation.getPrescription() != null){
           reservation.getPrescription().setReservation(reservation);
        }
            reservationService.addReservation(reservation);
    }

    @PutMapping("/reservations")
    public void updateReservation(@RequestBody Reservation reservation) {
        reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/reservations/{reservationId}")
    public void removeReservation(@PathVariable Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @PostMapping("/doctors/reservations")
    public List<Reservation> getAllReservationsForDoctor(@RequestBody Doctor doctor) {
        return reservationService.findAllByDoctor(doctor);
    }

    @PostMapping("/patients/reservations")
    public List<Reservation> getAllReservationsForPatient(@RequestBody Patient patient) {
        return reservationService.findAllByPatient(patient);
    }
}
