package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Reservation;
import com.example.clinicmanagementappbackend.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api")
public class RoleController {

    private final ReservationService reservationService;

    @GetMapping("/roles")
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

}
