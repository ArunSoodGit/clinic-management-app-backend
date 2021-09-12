package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
    Optional<Room> findByNumber(String number);
}
