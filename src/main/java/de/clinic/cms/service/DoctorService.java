package de.clinic.cms.service;

import de.clinic.cms.dto.DoctorRequestDTO;
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
     * @param dto The doctor entity to save.
     * @return The saved doctor entity.
     */
    public Doctor saveDoctor(DoctorRequestDTO dto) {
        Doctor doctor = Doctor.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .specialisation(dto.getSpecialisation())
                .phoneNumber(dto.getPhoneNumber())
                .build();

        return doctorRepository.save(doctor);
    }
}
