package com.example.clinicmanagementappbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Date date;

    @Column(name = "reservation_id")
    private Long reservationId;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            joinColumns = {@JoinColumn(name = "prescription_id")},
            inverseJoinColumns = {@JoinColumn(name = "medicine_id")}
    )
    private Set<Medicine> medicines;

}
