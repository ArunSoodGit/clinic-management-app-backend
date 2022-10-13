package com.example.clinicmanagementappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;

    @Column(name = "SurName")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "pesel")
    private String pesel;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Reservation> reservation;
}
