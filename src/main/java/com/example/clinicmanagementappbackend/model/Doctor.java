package com.example.clinicmanagementappbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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

    @OneToOne
    private Room room;

    @ManyToOne
    private Specialization specialization;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Reservation> reservation;

}
