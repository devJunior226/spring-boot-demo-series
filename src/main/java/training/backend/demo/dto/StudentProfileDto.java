package training.backend.demo.dto;

/**
 * DTO for {@link training.backend.demo.entity.StudentProfile}
 */
public record StudentProfileDto(
        Integer id,
        String biography,
        String studyDomain,
        String passion,
        Integer studentId
) { }