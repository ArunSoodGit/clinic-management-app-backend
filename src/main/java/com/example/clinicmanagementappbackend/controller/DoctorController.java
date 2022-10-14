package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Room;
import com.example.clinicmanagementappbackend.model.Specialization;
import com.example.clinicmanagementappbackend.service.DoctorService;
import com.example.clinicmanagementappbackend.service.RoomService;
import com.example.clinicmanagementappbackend.service.SpecializationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    public DoctorController(DoctorService doctorService, RoomService roomService, SpecializationService specializationService) {
        this.doctorService = doctorService;
        this.roomService = roomService;
        this.specializationService = specializationService;
    }

    @GetMapping()
    public ResponseEntity<List<Doctor>> getDoctors() {
        return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long doctorId) {
        return new ResponseEntity<>(doctorService.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + doctorId)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
//        Optional<Room> room = roomService.findByNumber(doctor.getRoom().getNumber());
//        Optional<Specialization> specialization = specializationService.findByName(doctor.getSpecialization().getName());
//        room.ifPresent(doctor::setRoom);
//        specialization.ifPresent(doctor::setSpecialization);
//        doctorService.addDoctor(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        doctorService.updateDoctor(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Long> removeDoctor(@PathVariable Long doctorId) {
        doctorService.removeDoctor(doctorId);
        return new ResponseEntity<>(doctorId, HttpStatus.OK);
    }
}
