package de.clinic.cms.controller;

import de.clinic.cms.dto.MedicalRecordRequestDTO;
import de.clinic.cms.entity.MedicalRecord;
import de.clinic.cms.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medical_records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    public MedicalRecord create(@RequestBody MedicalRecordRequestDTO dto) {
        return medicalRecordService.createMedicalRecord(dto);
    }
}
