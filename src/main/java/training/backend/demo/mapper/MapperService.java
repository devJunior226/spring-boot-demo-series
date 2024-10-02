package training.backend.demo.mapper;

import org.springframework.stereotype.Service;
import training.backend.demo.dto.StudentPublicDataDto;
import training.backend.demo.dto.SchoolDto;
import training.backend.demo.dto.SchoolForAdminDto;
import training.backend.demo.dto.StudentDto;
import training.backend.demo.dto.StudentForAdminDto;
import training.backend.demo.entity.School;
import training.backend.demo.entity.Student;

import java.util.stream.Collectors;

@Service
public class MapperService {

    /**
     * This method will map the school dto to school entity.
     *
     * @param schoolDto
     * @return a school dto.
     */
    public School maps(final SchoolDto schoolDto) {
        if (schoolDto == null) {
            return null;
        }

        School school = new School();
        school.setId(schoolDto.getId());
        school.setName(schoolDto.getName());
        school.setAddress(schoolDto.getAddress());
        school.setHeadmaster(schoolDto.getHeadmaster());
        school.setStudents(schoolDto.getStudents());

        return school;
    }

    /**
     * This method will map the school entity to a school dto.
     *
     * @param school
     * @return a school dto.
     */
    public SchoolDto maps(final School school) {
        if (school == null) {
            return null;
        }
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(school.getId());
        schoolDto.setName(school.getName());
        schoolDto.setAddress(school.getAddress());
        schoolDto.setHeadmaster(school.getHeadmaster());

        toStudentsListDto(school, schoolDto);
        return schoolDto;
    }

    /**
     * Return a list of students dto of the school.
     *
     * @param school
     * @param schoolDto
     */
    private void toStudentsListDto(School school, SchoolDto schoolDto) {
        if (school.getStudents() != null) {
            schoolDto.setStudents(school.getStudents()
                    .stream()
                    .map(this::maps)
                    .collect(Collectors.toList()));
        }
    }

    /**
     * From StudentDto to Student.
     *
     * @param studentDto
     * @return a student dto
     */
    public Student maps(final StudentDto studentDto) {
        if (studentDto == null) {
            return null;
        }

        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());

        School school = new School();
        school.setId(studentDto.getSchoolId());
        student.setSchool(school);

        return student;
    }

    /**
     * From dto to student.
     *
     * @param student
     * @return a student
     */
    public StudentDto maps(final Student student) {
        if (student == null) {
            return null;
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setAge(student.getAge());

        studentDto.setSchoolId(student.getSchool() != null ? student.getSchool().getId() : null);
        return studentDto;
    }

    /**
     * Return a dto with only the names, email, age and school of the student.
     *
     * @param student
     * @return a dto of student to display inside admin dashboard.
     */
    public StudentForAdminDto toStudentForAdminDto(final Student student) {
        if (student == null) {
            return null;
        }

        StudentForAdminDto studentForAdminDto = new StudentForAdminDto();
        studentForAdminDto.setFirstName(student.getFirstName());
        studentForAdminDto.setLastName(student.getLastName());
        studentForAdminDto.setEmail(student.getEmail());
        studentForAdminDto.setAge(student.getAge());

        School school = new School();
        studentForAdminDto.setSchoolName(student.getSchool() != null ? student.getSchool().getName() : null);

        return studentForAdminDto;
    }


    /**
     * Return only the school name, its headmaster and its address.
     *
     * @param school
     * @return a dto without students list.
     */
    public SchoolForAdminDto toSchoolForAdminDto(final School school) {
        if (school == null) {
            return null;
        }
        SchoolForAdminDto studentForAdminDto = new SchoolForAdminDto();
        studentForAdminDto.setName(school.getName());
        studentForAdminDto.setAddress(school.getAddress());
        studentForAdminDto.setHeadmaster(school.getHeadmaster());
        return studentForAdminDto;
    }

    /**
     * Return only the student firstname and lastname.
     *
     * @param student
     * @return a dto.
     */
    public StudentPublicDataDto toStudentPublicDataDto(final Student student) {
        if (student == null) {
            return null;
        }
        StudentPublicDataDto studentPublicDataInfo = new StudentPublicDataDto();
        studentPublicDataInfo.setNames(student.getFirstName() + " " + student.getLastName());
        studentPublicDataInfo.setSchoolName(student.getSchool() != null ? student.getSchool().getName() : null);
        return studentPublicDataInfo;
    }
}
