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

    private boolean social_work;
    private String blood_type;
    @OneToOne
    private Responsible responsible;
    @OneToMany(mappedBy = "patient")
    private List<Shift> shiftList;


    public Patient(String name, String surname, String dni, Date birthdate, String phone, String address, boolean social_work, String blood_type, Responsible responsible, List<Shift> shiftList) {
        super(name, surname, dni, birthdate, phone, address);
        this.social_work = social_work;
        this.blood_type = blood_type;
        this.responsible = responsible;
        this.shiftList = shiftList;
    }

}
