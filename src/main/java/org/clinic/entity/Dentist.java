package org.clinic.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dentist extends Person{
    private String speciality;

    public Dentist(String name, String surname, String dni, Date birthdate, String phone, String address, String speciality) {
        super(name, surname, dni, birthdate, phone, address);
        this.speciality = speciality;
    }

    public Dentist(int id, String name, String surname, String dni, Date birthdate, String phone, String address, String speciality) {
        super(id, name, surname, dni, birthdate, phone, address);
        this.speciality = speciality;
    }
}
