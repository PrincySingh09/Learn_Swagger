package com.rest.swagger_assignment.service;


import java.util.List;
// Add the necessary dependency for javax.persistence
import java.util.NoSuchElementException;
import java.util.Optional;

import com.rest.swagger_assignment.entities.Patient;
import com.rest.swagger_assignment.repositories.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

  @Autowired
  private PatientRepository patientRepository;

  public List<Patient> getAllPatients() {
    List<Patient> patientList = patientRepository.findAll();
    return patientList;
  }

  public Patient savePatient(Patient patient) {
    return patientRepository.save(patient);
  }

  public Patient getPatient(Long id) {
    //
    Patient patient = patientRepository.findByIdOrThrow(id);
    return patient;
  }

  public Patient updatePatient(Long id, Patient patient) {
    Patient patientToUpdate = patientRepository.findByIdOrThrow(id);
    patientToUpdate.setFirstName(patient.getFirstName());
    patientToUpdate.setLastName(patient.getLastName());
    patientToUpdate.setDateOfBirth(patient.getDateOfBirth());
    patientToUpdate.setGender(patient.getGender());
    return patientRepository.save(patientToUpdate);
  }

  public String deleteById(Long id) {
    patientRepository.deleteById(id);
    return "Deleted Patient with patient id " + id;
  }
}
