package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.AppUser;
import com.example.clinicmanagementappbackend.model.MyUserDetails;
import com.example.clinicmanagementappbackend.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepo appUserRepo;

    @Autowired
    public UserDetailsServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepo.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Could not find user");
        } else {
            return new MyUserDetails(user.get());

        }

    }
}
