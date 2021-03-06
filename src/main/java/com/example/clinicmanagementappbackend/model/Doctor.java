package com.example.clinicmanagementappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Room room;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Specialization specialization;



    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    Set<Reservation> reservation;

}
