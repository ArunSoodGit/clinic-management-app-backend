package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.AppUser;
import com.example.clinicmanagementappbackend.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class AppUserService {

    private final AppUserRepo appUserRepo;

    public Optional<AppUser> getUserByUserName(String username) {
        return appUserRepo.findByUsername(username);
    }
}
