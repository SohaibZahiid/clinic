package org.clinic.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient extends Person {

    private String blood_type;

    public Patient(String name, String surname, String dni, Date birthdate, String phone, String address, String blood_type) {
        super(name, surname, dni, birthdate, phone, address);

        this.blood_type = blood_type;
    }

}
