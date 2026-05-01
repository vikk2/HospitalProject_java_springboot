package com.example.hospital.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "billings")
public class Billing {

    @Id
    private String id;

    private String patientId;
    private double amount;
    private String billingDate;
    private String paymentStatus; // Paid / Unpaid
}