package com.example.clinicmanagementappbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;


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


    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    Set<Prescription> prescription;
}
