package com.example.clinicmanagementappbackend.repository;

import com.example.clinicmanagementappbackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
}
