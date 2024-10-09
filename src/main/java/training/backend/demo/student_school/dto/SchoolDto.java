package training.backend.demo.student_school.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import training.backend.demo.student_school.entity.School;

import java.util.Collection;

/**
 * DTO for {@link School}
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SchoolDto {
    private Integer id;
    private String name;
    private String address;
    private String headmaster;
    private Collection students;
}