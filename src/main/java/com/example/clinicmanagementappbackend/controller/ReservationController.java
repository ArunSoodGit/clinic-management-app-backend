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
            reservation.getPrescription().setReservationId(reservation.getId());
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

    @PostMapping("/doctors/{doctor-id}")
    public List<Reservation> getAllReservationsForDoctor( @PathVariable("doctor-id") Long doctorId) {
        return reservationService.findAllByDoctor(doctorId);
    }

    @PostMapping("/patients/{patient-id}")
    public List<Reservation> getAllReservationsForPatient( @PathVariable("patient-id") Long patientId) {
        return reservationService.findAllByPatient(patientId);
    }
}
