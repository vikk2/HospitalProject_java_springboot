package com.example.hospital.controller;

import com.example.hospital.model.Billing;
import com.example.hospital.repository.BillingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    private final BillingRepository repository;

    public BillingController(BillingRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Billing create(@RequestBody Billing billing) {
        return repository.save(billing);
    }

    @GetMapping
    public List<Billing> getAll() {
        return repository.findAll();
    }

    @GetMapping("/patient/{patientId}")
    public List<Billing> getByPatient(@PathVariable String patientId) {
        return repository.findByPatientId(patientId);
    }

    @GetMapping("/unpaid")
    public List<Billing> getUnpaid() {
        return repository.findByPaymentStatus("Unpaid");
    }
}