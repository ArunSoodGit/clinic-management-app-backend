package com.example.clinicmanagementappbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @OneToOne
    private Reservation reservation;

    @Column(name = "Description")
    private String description;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL)
    Set<Prescription> prescription;
}
