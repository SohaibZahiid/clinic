package org.clinic.entity;


import lombok.*;


import jakarta.persistence.*;
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
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    private String phone;
    private String address;

    public Person(String name, String surname, String dni, Date birthdate, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.birthdate = birthdate;
        this.phone = phone;
        this.address = address;
    }
}
