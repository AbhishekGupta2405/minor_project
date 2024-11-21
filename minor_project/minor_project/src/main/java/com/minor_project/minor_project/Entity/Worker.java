package com.minor_project.minor_project.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Worker_register")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String familyPhoneNumber;
    private String permanentAddress;
    private String currentAddress;
    private String aadhaarNumber;
    private String policeVerificationStatus;
    private String workCategory;
    private Integer yearsOfExperience;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFamilyPhoneNumber() {
        return familyPhoneNumber;
    }

    public void setFamilyPhoneNumber(String familyPhoneNumber) {
        this.familyPhoneNumber = familyPhoneNumber;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getPoliceVerificationStatus() {
        return policeVerificationStatus;
    }

    public void setPoliceVerificationStatus(String policeVerificationStatus) {
        this.policeVerificationStatus = policeVerificationStatus;
    }

    public String getWorkCategory() {
        return workCategory;
    }

    public void setWorkCategory(String workCategory) {
        this.workCategory = workCategory;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}

