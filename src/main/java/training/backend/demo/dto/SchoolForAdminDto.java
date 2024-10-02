package training.backend.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import training.backend.demo.entity.School;

/**
 * DTO for {@link School}
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SchoolForAdminDto {
    private String name;
    private String address;
    private String headmaster;
}