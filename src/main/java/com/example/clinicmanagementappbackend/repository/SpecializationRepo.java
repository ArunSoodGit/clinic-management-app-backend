package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepo extends JpaRepository<Specialization, Long> {
}
