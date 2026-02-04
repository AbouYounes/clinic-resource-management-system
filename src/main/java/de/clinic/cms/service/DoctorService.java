package de.clinic.cms.service;

import de.clinic.cms.entity.Doctor;
import de.clinic.cms.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    /**
     * Retrieves all doctors from the database.
     * @return List of all doctors.
     */
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    /**
     * Saves a new doctor or updates an existing one.
     * @param doctor The doctor entity to save.
     * @return The saved doctor entity.
     */
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
