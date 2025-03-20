package com.hospital.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patients") // ✅ Renamed table for best practices
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    
    private String patientName;
    private String patientCity;
    private String patientNumber;
    private String patientDisease;

    // ✅ Default Constructor
    public Patient() {}

    // ✅ Parameterized Constructor
    public Patient(String patientName, String patientCity, String patientNumber, String patientDisease) {
        this.patientName = patientName;
        this.patientCity = patientCity;
        this.patientNumber = patientNumber;
        this.patientDisease = patientDisease;
    }

    // ✅ Getters & Setters
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientDisease() {
        return patientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        this.patientDisease = patientDisease;
    }
}




