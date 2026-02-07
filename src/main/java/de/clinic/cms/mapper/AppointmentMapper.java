package de.clinic.cms.mapper;

import de.clinic.cms.dto.AppointmentResponseDTO;
import de.clinic.cms.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentResponseDTO toDTO(Appointment appointment) {
        return AppointmentResponseDTO.builder()
                .id(appointment.getId())
                .appointmentDate(appointment.getAppointmentDate())
                .reason(appointment.getReason())
                .patientName(appointment.getPatient().getFirstname() + " " + appointment.getPatient().getLastname())
                .doctorName(appointment.getDoctor().getFirstname() + " " + appointment.getDoctor().getLastname())
                .build();
    }
}
