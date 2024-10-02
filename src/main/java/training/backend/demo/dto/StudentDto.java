package training.backend.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Integer schoolId;
}
