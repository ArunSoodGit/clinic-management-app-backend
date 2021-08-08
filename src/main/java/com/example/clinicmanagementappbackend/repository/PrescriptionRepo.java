package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Prescription;
import com.example.clinicmanagementappbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {
    Optional<Prescription> getPrescriptionByReservation(Reservation reservation);
}
