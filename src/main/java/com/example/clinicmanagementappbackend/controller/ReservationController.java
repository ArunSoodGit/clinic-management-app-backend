package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Doctor;
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

    @GetMapping("/reservation")
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservation/{reservationId}")
    public Reservation getReservationById(@PathVariable Long reservationId) {
        return reservationService.findReservationById(reservationId).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/reservation")
    public void addReservation(@RequestBody Reservation Reservation) {
        reservationService.addReservation(Reservation);
    }

    @PutMapping("/reservation")
    public void updateReservation(@RequestBody Reservation Reservation) {
        reservationService.updateReservation(Reservation);
    }

    @DeleteMapping("/reservation/{reservationId}")
    public void removeReservation(@PathVariable Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @PostMapping("/doctors/reservation")
    public List<Reservation> getAllReservationsForDoctor(@RequestBody Doctor doctor) {
        return reservationService.findAllByCustomer(doctor);
    }
}
