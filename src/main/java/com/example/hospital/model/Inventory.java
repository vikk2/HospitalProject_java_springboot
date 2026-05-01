package com.example.hospital.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "inventory")
public class Inventory {

    @Id
    private String id;

    private String itemName;
    private int quantity;
    private String expirationDate;
}