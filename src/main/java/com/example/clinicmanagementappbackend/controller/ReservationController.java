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

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservations/{reservationId}")
    public Reservation getReservationById(@PathVariable Long reservationId) {
        return reservationService.findReservationById(reservationId).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/reservations")
    public void addReservation(@RequestBody Reservation Reservation) {
        reservationService.addReservation(Reservation);
    }

    @PutMapping("/reservations")
    public void updateReservation(@RequestBody Reservation Reservation) {
        reservationService.updateReservation(Reservation);
    }

    @DeleteMapping("/reservations/{reservationId}")
    public void removeReservation(@PathVariable Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    @PostMapping("/doctors/reservations")
    public List<Reservation> getAllReservationsForDoctor(@RequestBody Doctor doctor) {
        return reservationService.findAllByDoctor(doctor);
    }
}
