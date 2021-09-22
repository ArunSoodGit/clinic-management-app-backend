package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.AppUser;
import com.example.clinicmanagementappbackend.model.Role;
import com.example.clinicmanagementappbackend.repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class RoleService {

    private final RoleRepo roleRepo;

    public Role findByNumber(AppUser user) {
        return roleRepo.findRoleByUsers(user);
    }
}
