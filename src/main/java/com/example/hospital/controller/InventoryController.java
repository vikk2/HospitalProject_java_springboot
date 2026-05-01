package com.example.hospital.controller;

import com.example.hospital.model.Inventory;
import com.example.hospital.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository repository;

    public InventoryController(InventoryRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory item) {
        return repository.save(item);
    }

    @GetMapping
    public List<Inventory> getAll() {
        return repository.findAll();
    }

    @GetMapping("/expiring/{date}")
    public List<Inventory> getExpiring(@PathVariable String date) {
        return repository.findByExpirationDateLessThan(date);
    }
}