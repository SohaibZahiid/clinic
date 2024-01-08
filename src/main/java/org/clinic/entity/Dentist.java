package org.clinic.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dentist extends Person{
    private String speciality;
    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;

    public Dentist(int id, String name, String surname, String dni, LocalDate birthdate, String phone, String address, String speciality) {
        super(id, name, surname, dni, birthdate, phone, address);
        this.speciality = speciality;
    }
}
