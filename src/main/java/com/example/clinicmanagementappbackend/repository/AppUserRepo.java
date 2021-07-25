package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username); //pojemnik na zmienną dowolnego typu, która może mieć wartość null

}
