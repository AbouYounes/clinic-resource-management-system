package de.clinic.cms.service;

import de.clinic.cms.dto.MedicalRecordRequestDTO;
import de.clinic.cms.entity.MedicalRecord;
import de.clinic.cms.entity.Patient;
import de.clinic.cms.repository.MedicalRecordRepository;
import de.clinic.cms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;

    public MedicalRecord createMedicalRecord(MedicalRecordRequestDTO dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + dto.getPatientId()));

        MedicalRecord medicalRecord = MedicalRecord.builder()
                .recordDate(dto.getRecordDate())
                .diagnosis(dto.getDiagnosis())
                .treatment(dto.getTreatment())
                .patient(patient)
                .build();

        return medicalRecordRepository.save(medicalRecord);
    }
}
