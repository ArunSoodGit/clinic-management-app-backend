package com.example.clinicmanagementappbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Status")
    private String status;

    @Column(name = "Date")
    private Date visitDate;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    @Column(name = "Description")
    private String description;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    Prescription prescription;
}
