package com.hospital.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospital.demo.repository.PatientRepository;
import com.hospital.demo.entity.Patient;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @GetMapping("/add-patient")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "create";
    }

    @GetMapping("/")
    public String showPatients(Model model) {
        List<Patient> patients = repository.findAll();
        model.addAttribute("patients", patients);
        return "view";
    }

    @PostMapping("/patients")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        repository.save(patient);
        return "redirect:/";
    }

    @GetMapping("/update/{patientId}")
    public String updatePatientForm(@PathVariable("patientId") Long patientId, Model model) {
        Patient patient = repository.findById(patientId).orElse(null);
        model.addAttribute("patient", patient);
        return "update";
    }

    @PostMapping("/update-patient")
    public String updatePatient(@ModelAttribute("patient") Patient updatedPatient) {
        repository.save(updatedPatient);
        return "redirect:/";
    }

    @PostMapping("/delete-patient")
    public String deleteAllPatients() {
        repository.deleteAll();
        return "redirect:/";
    }
}
