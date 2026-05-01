package com.example.hospital.repository;

import com.example.hospital.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

    List<Inventory> findByExpirationDateLessThan(String date);
}