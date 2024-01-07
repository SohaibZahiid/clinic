package org.clinic.entity;




import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Secretary extends Person{

    private String sector;
    @OneToOne
    private User user;

    public Secretary(String name, String surname, String dni, Date birthdate, String phone, String address, String sector, User user) {
        super(name, surname, dni, birthdate, phone, address);
        this.sector = sector;
        this.user = user;
    }
}
