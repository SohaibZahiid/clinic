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
    @OneToMany(mappedBy = "dentist")
    private List<Shift> shifts;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    private Schedule schedule;


    public Dentist(String name, String surname, String dni, Date birthdate, String phone, String address, String speciality, List<Shift> shifts, User user, Schedule schedule) {
        super(name, surname, dni, birthdate, phone, address);
        this.speciality = speciality;
        this.shifts = shifts;
        this.user = user;
        this.schedule = schedule;
    }


}
