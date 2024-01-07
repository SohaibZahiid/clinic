package org.clinic.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shift_id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String affection;
    @ManyToOne
    @JoinColumn(name = "dentist_id" )
    private Dentist dentist;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
