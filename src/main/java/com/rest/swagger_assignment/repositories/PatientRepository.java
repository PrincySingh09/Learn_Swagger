package com.rest.swagger_assignment.repositories;

import com.rest.swagger_assignment.entities.*;
import com.rest.swagger_assignment.exception.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // rewrite findbyId to return an exception if the patient is not found
    default Patient findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new UserNotFoundException("Patient not found"));
    }
    

}
