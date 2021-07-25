package com.example.clinicmanagementappbackend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PrescriptionMedicineKey implements Serializable {

    @Column(name = "prescription_id")
    Long prescription_id;

    @Column(name = "medicine_id")
    Long medicine_id;
}
