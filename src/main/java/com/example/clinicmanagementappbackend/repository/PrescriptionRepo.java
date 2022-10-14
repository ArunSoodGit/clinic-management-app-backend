package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Prescription;
import com.example.clinicmanagementappbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {
    Optional<Prescription> getPrescriptionByReservationId(Long reservationId);

    @Override
    @Query("Select prescription from Prescription prescription join fetch prescription.medicines")
    List<Prescription> findAll();
}
