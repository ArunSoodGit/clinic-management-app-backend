package com.example.clinicmanagementappbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "prescription")
    Set<PrescriptionMedicine> prescriptionMedicineSet;

}
