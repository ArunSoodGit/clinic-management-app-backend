package com.example.clinicmanagementappbackend.model;

import javax.persistence.*;

@Entity
public class PrescriptionMedicine {

    @EmbeddedId
    PrescriptionMedicineKey id;

    @ManyToOne
    @MapsId("medicineId")
    @JoinColumn(name = "medicine_id")
    Medicine medicine;

    @ManyToOne
    @MapsId("prescriptionId")
    @JoinColumn(name = "prescription_id")
    Prescription prescription;

}
