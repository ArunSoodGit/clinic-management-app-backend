package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.AppUser;
import com.example.clinicmanagementappbackend.model.Patient;
import com.example.clinicmanagementappbackend.service.AppUserService;
import com.example.clinicmanagementappbackend.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api")
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/users/{userName}")
    public AppUser getUserByUserName(@PathVariable String userName) {
        return appUserService.getUserByUserName(userName).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + userName));
    }
}
