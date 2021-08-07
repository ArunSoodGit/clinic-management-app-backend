package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByDoctor(Doctor doctor);
}
