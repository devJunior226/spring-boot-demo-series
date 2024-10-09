package training.backend.demo.student_school.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentForAdminDto {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String schoolName;
}
