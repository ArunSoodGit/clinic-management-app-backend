package com.example.clinicmanagementappbackend.controller;

import com.example.clinicmanagementappbackend.model.Medicine;
import com.example.clinicmanagementappbackend.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping()
    public List<Medicine> getMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{medicineId}")
    public Medicine getMedicineById(@PathVariable Long medicineId) {
        return medicineService.findMedicineById(medicineId).orElseThrow(() -> new IllegalArgumentException("Unsupported value: " + medicineId));
    }

    @PostMapping()
    public void addMedicine(@RequestBody Medicine medicine) {
        medicineService.addMedicine(medicine);
    }

    @PutMapping()
    public void updateMedicine(@RequestBody Medicine medicine) {
        medicineService.updateMedicine(medicine);
    }

    @DeleteMapping("/{medicineId}")
    public void removeMedicine(@PathVariable Long medicineId) {
        medicineService.removeMedicine(medicineId);
    }
}
