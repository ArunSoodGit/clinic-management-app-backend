package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    @Override
    @Query("select DISTINCT  doctor from Doctor doctor  left join fetch doctor.reservations left join fetch doctor.specialization left join fetch doctor.room")
    List<Doctor> findAll();

    @Override
    @Query("select DISTINCT  doctor from Doctor doctor left join fetch doctor.reservations join fetch doctor.specialization where doctor.id = :doctorId")
    Optional<Doctor> findById(Long doctorId);
}
