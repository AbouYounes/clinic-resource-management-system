package de.clinic.cms.mapper;

import de.clinic.cms.dto.DoctorRequestDTO;
import de.clinic.cms.dto.DoctorResponseDTO;
import de.clinic.cms.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toEntity(DoctorRequestDTO dto) {
        return  Doctor.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .specialisation(dto.getSpecialisation())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    public DoctorResponseDTO toDTO(Doctor doctor) {
        return DoctorResponseDTO.builder()
                .id(doctor.getId())
                .firstname(doctor.getFirstname())
                .lastname(doctor.getLastname())
                .specialisation(doctor.getSpecialisation())
                .build();
    }
}
