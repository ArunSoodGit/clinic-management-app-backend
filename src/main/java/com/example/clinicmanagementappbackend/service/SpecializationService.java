package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.Specialization;
import com.example.clinicmanagementappbackend.repository.RoomRepo;
import com.example.clinicmanagementappbackend.repository.SpecializationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class SpecializationService {

    private final SpecializationRepo specializationRepo;

    public Optional<Specialization> findByName(String name) {
        return specializationRepo.findByName(name);
    }
}
