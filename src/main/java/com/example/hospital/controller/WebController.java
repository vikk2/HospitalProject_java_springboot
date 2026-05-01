package com.example.hospital.controller;

import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.model.Appointment;
import com.example.hospital.repository.BillingRepository;
import com.example.hospital.model.Billing;
import com.example.hospital.repository.InventoryRepository;
import com.example.hospital.model.Inventory;


@Controller
public class WebController {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final BillingRepository billingRepository;
    private final InventoryRepository inventoryRepository;

    public WebController(PatientRepository patientRepository,
                         DoctorRepository doctorRepository,
                         AppointmentRepository appointmentRepository,
                         BillingRepository billingRepository,
                         InventoryRepository inventoryRepository) {

        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        this.billingRepository = billingRepository;
        this.inventoryRepository = inventoryRepository;
    }

    // index page
    @GetMapping("/")
    public String home() {
        return "index";
    }


    // Show form
    @GetMapping("/patients/form")
    public String showForm() {
        return "patient-form";
    }

    // Handle submit
    @PostMapping("/patients/save")
    public String savePatient(Patient patient) {
        patientRepository.save(patient);
        return "redirect:/patients/form";
    }

    @GetMapping("/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "patient-list";
    }

    @GetMapping("/appointments/form")
    public String showAppointmentForm(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());
        return "appointment-form";
    }

    @PostMapping("/appointments/save")
    public String saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "appointment-list";
    }

    @GetMapping("/billings/form")
    public String showBillingForm(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "billing-form";
    }

    @PostMapping("/billings/save")
    public String saveBilling(Billing billing) {
        billingRepository.save(billing);
        return "redirect:/billings";
    }

    @GetMapping("/billings")
    public String listBillings(Model model) {
        model.addAttribute("billings", billingRepository.findAll());
        return "billing-list";
    }

    @GetMapping("/inventory/form")
    public String showInventoryForm() {
        return "inventory-form";
    }

    @PostMapping("/inventory/save")
    public String saveInventory(Inventory item) {
        inventoryRepository.save(item);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String listInventory(Model model) {
        model.addAttribute("items", inventoryRepository.findAll());
        return "inventory-list";
    }
}