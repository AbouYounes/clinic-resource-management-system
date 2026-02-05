package de.clinic.cms.controller;

import de.clinic.cms.dto.DoctorRequestDTO;
import de.clinic.cms.entity.Doctor;
import de.clinic.cms.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    /**
     * Endpoint to retrieve all doctors.
     * @return List of doctors.
     */
    @GetMapping
    public List<Doctor> getAllDoctor() {
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody DoctorRequestDTO dto) {
        return ResponseEntity.ok(doctorService.saveDoctor(dto));
    }
}
