package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.Room;
import com.example.clinicmanagementappbackend.repository.ReservationRepo;
import com.example.clinicmanagementappbackend.repository.RoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class RoomService {

    private final RoomRepo roomRepo;

    public Optional<Room> findByNumber(String number) {
        return roomRepo.findByNumber(number);
    }
}
