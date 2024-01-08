package org.clinic.entity;


import lombok.*;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String dni;
    private LocalDate birthdate;
    private String phone;
    private String address;

}
