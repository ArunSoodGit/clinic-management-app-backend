package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Room;
import com.example.clinicmanagementappbackend.model.Specialization;
import com.example.clinicmanagementappbackend.service.DoctorService;
import com.example.clinicmanagementappbackend.service.RoomService;
import com.example.clinicmanagementappbackend.service.SpecializationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final RoomService roomService;
    private final SpecializationService specializationService;
    private final ObjectMapper objectMapper;

    @Autowired
    public DoctorController(DoctorService doctorService, RoomService roomService, SpecializationService specializationService, ObjectMapper objectMapper) {
        this.doctorService = doctorService;
        this.roomService = roomService;
        this.specializationService = specializationService;
        this.objectMapper = objectMapper;
    }

    @GetMapping()
    public List<Doctor> getDoctors() {
        return doctorService.getAll();
    }

    @GetMapping("/{doctorId}")
    public Doctor getDoctorById(@PathVariable Long doctorId) {
        return doctorService.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + doctorId));
    }

    @PostMapping()
    public void addDoctor(@RequestBody Doctor doctor) {
        Optional<Room> room = roomService.findByNumber(doctor.getRoom().getNumber());
        Optional<Specialization> specialization = specializationService.findByName(doctor.getSpecialization().getName());
        room.ifPresent(doctor::setRoom);
        specialization.ifPresent(doctor::setSpecialization);
        doctorService.addDoctor(doctor);
    }

    @PutMapping()
    public void updateDoctor(@RequestBody Doctor doctor) {
        doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/{doctorId}")
    public void removeDoctor(@PathVariable Long doctorId) {
        doctorService.removeDoctor(doctorId);
    }
}
