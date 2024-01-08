package org.clinic.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient extends Person {

    private String blood_type;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;


    public Patient(int id, String name, String surname, String dni, LocalDate birthdate, String phone, String address, String blood_type) {
        super(id, name, surname, dni, birthdate, phone, address);
        this.blood_type = blood_type;
    }
}
