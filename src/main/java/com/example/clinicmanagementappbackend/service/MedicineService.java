package com.example.clinicmanagementappbackend.service;

import com.example.clinicmanagementappbackend.model.Doctor;
import com.example.clinicmanagementappbackend.model.Medicine;
import com.example.clinicmanagementappbackend.model.PrescriptionMedicine;
import com.example.clinicmanagementappbackend.repository.MedicineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class MedicineService {

    private final MedicineRepo medicineRepo;


    public List<Medicine> getAllMedicines() {
        return medicineRepo.findAll();
    }

    public Optional<Medicine> findMedicineById(Long medicineId) {
        return medicineRepo.findById(medicineId);
    }

    public void addMedicine(Medicine medicine) {
        medicineRepo.save(medicine);
    }

    public void updateMedicine(Medicine medicine) {
        if (medicineRepo.existsById(medicine.getId())) {
            medicineRepo.save(medicine);
        }
    }

    public void removeMedicine(Long medicineId) {
        if (medicineRepo.existsById(medicineId)) {
            medicineRepo.deleteById(medicineId);
        }
    }

    public List<Medicine> findMedicinesByPrescription(PrescriptionMedicine prescriptionMedicine) {
        return medicineRepo.findMedicinesByPrescriptionMedicine(prescriptionMedicine);
    }
}
