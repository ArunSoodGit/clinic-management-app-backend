package com.example.clinicmanagementappbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "SurName")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Reservation> reservations;
}
