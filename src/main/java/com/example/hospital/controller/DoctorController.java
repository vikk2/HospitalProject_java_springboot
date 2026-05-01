package com.example.hospital.controller;

import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorRepository repository;

    public DoctorController(DoctorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        return repository.save(doctor);
    }

    @GetMapping
    public List<Doctor> getAll() {
        return repository.findAll();
    }
}