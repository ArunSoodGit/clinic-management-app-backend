package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Patient;
import com.example.clinicmanagementappbackend.model.Reservation;
import com.example.clinicmanagementappbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping()
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{reservationId}")
    public Reservation getReservationById(@PathVariable Long reservationId) {
        return reservationService.findReservationById(reservationId).orElseThrow(RuntimeException::new);
    }

    @PostMapping()
    public void addReservation(@RequestBody Reservation reservation) {
        if (reservation.getPrescription() != null) {
            reservation.getPrescription().setReservation(reservation);
        }
        reservationService.addReservation(reservation);
    }

    @PutMapping()
    public void updateReservation(@RequestBody Reservation reservation) {
        reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{reservationId}")
    public void removeReservation(@PathVariable Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @PostMapping("/doctors")
    public List<Reservation> getAllReservationsForDoctor(@RequestBody Doctor doctor) {
        return reservationService.findAllByDoctor(doctor);
    }

    @PostMapping("/patients")
    public List<Reservation> getAllReservationsForPatient(@RequestBody Patient patient) {
        return reservationService.findAllByPatient(patient);
    }
}
