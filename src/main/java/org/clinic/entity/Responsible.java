package org.clinic.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Responsible extends Person{
    private String relation;

    public Responsible(String name, String surname, String dni, Date birthdate, String phone, String address, String relation) {
        super(name, surname, dni, birthdate, phone, address);
        this.relation = relation;
    }

}
