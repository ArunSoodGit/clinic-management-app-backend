package com.example.clinicmanagementappbackend.controller;
import com.example.clinicmanagementappbackend.model.Medicine;
import com.example.clinicmanagementappbackend.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api")
public class MedicineController {

    private final MedicineService medicineService;

    @GetMapping("/medicines")
    public List<Medicine> getMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/medicines/{medicineId}")
    public Medicine getMedicineById(@PathVariable Long medicineId) {
        return medicineService.findMedicineById(medicineId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + medicineId));
    }

    @PostMapping("/medicines")
    public void addMedicine(@RequestBody Medicine doctor) {
        medicineService.addMedicine(doctor);
    }

    @PutMapping("/medicines")
    public void updateMedicine(@RequestBody Medicine doctor) {
        medicineService.updateMedicine(doctor);
    }

    @DeleteMapping("/medicines/{medicineId}")
    public void removeMedicine(@PathVariable Long medicineId) {
        medicineService.removeMedicine(medicineId);
    }

//    @PostMapping("/prescriptions/medicines")
//    public List<Medicine> findMedicinesByPrescription(@RequestBody PrescriptionMedicine prescriptionMedicine) {
//        return medicineService.findMedicinesByPrescription(prescriptionMedicine);
//    }

}
