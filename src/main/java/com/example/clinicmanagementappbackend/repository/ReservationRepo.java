package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Patient;
import com.example.clinicmanagementappbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByDoctorId(Long id);
    List<Reservation> findAllByPatientId(Long id);
}
