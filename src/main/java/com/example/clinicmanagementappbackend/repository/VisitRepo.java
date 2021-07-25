package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepo extends JpaRepository<Visit, Long> {
}
