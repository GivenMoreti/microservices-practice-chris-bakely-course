package com.example.patient_service.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "name is required")
    @Size(max = 30, message = "Name too long")
    private String name;

    @Column(unique = true)
    @NotNull(message = "email is required")
    @Size(max = 30, message = "Email too long")
    @Email
    private String email;

    @NotNull(message = "address is required")
    @Size(max = 50, message = "Address too long")
    private String address;

    @NotNull
    private LocalDate registeredDate = LocalDate.now();
    @NotNull
    private LocalDate dateOfBirth;



    

    // Getters and setters below

    // public Patient(UUID id,
    //         @NotNull(message = "name is required") @Size(max = 30, message = "Name too long") String name,
    //         @NotNull(message = "email is required") @Size(max = 30, message = "Email too long") @Email String email,
    //         @NotNull(message = "address is required") @Size(max = 50, message = "Address too long") String address,
    //         @NotNull LocalDate registeredDate, @NotNull LocalDate dateOfBirth) {
    //     this.id = id;
    //     this.name = name;
    //     this.email = email;
    //     this.address = address;
    //     this.registeredDate = registeredDate;
    //     this.dateOfBirth = dateOfBirth;
    // }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getRegisteredDate() {
        return registeredDate;
    }
    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    

 

}
