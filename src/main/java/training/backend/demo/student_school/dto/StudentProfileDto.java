package training.backend.demo.student_school.dto;

import training.backend.demo.student_school.entity.StudentProfile;

/**
 * DTO for {@link StudentProfile}
 */
public record StudentProfileDto(
        Integer id,
        String biography,
        String studyDomain,
        String passion,
        Integer studentId
) { }