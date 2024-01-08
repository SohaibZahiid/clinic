package org.clinic.service;

import org.clinic.dao.PatientDao;
import org.clinic.entity.Dentist;
import org.clinic.entity.Patient;

import java.util.List;

public class PatientService {
    PatientDao dao;

    public PatientService() {
        dao = new PatientDao();
    }

    public Patient save(Patient patient) {
        return dao.save(patient);
    }

    public List<Patient> getAllPatients() {
        return dao.getAllPatients();
    }

    public Patient delete(int id) {
        return dao.delete(id);
    }

    public Patient getPatientById(int id) {
        return  dao.getPatientById(id);
    }

    public Patient update(Patient patient) {
        return dao.update(patient);
    }
}
