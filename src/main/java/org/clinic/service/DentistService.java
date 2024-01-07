package org.clinic.service;

import org.clinic.dao.DentistDao;
import org.clinic.entity.Dentist;
import org.clinic.entity.User;

import java.util.List;

public class DentistService {
    DentistDao dentistDao = new DentistDao();
    public DentistService() {
        dentistDao = new DentistDao();
    }

    public Dentist save(Dentist dentist) {
        return dentistDao.save(dentist);
    }

    public List<Dentist> getAllDentists() {
        return dentistDao.getAllDentists();
    }
}
