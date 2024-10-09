package training.backend.demo.student_school.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import training.backend.demo.student_school.dto.StudentPublicDataDto;
import training.backend.demo.student_school.dto.SchoolDto;
import training.backend.demo.student_school.dto.SchoolForAdminDto;
import training.backend.demo.student_school.dto.StudentDto;
import training.backend.demo.student_school.dto.StudentForAdminDto;
import training.backend.demo.student_school.entity.School;
import training.backend.demo.student_school.entity.Student;
import training.backend.demo.student_school.mapper.MapperService;
import training.backend.demo.student_school.repository.SchoolRepository;
import training.backend.demo.student_school.repository.StudentRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UniversityService {
    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;
    private final MapperService mapper;

    /**
     * This method save a school in the database.
     * @param schoolDto
     * @return the school we just saved.
     */
    public SchoolForAdminDto saveSchool(final SchoolDto schoolDto) {
        School newSchool = this.mapper.maps(schoolDto);
        Integer schoolId = new Random().nextInt();
        newSchool.setId(schoolId);
        School schoolSaved = this.schoolRepository.save(newSchool);
        return this.mapper.toSchoolForAdminDto(schoolSaved);
    }

    /**
     * Return the list of schools.
     * @return a list of schools.
     */
    public List<SchoolForAdminDto> findSchools() {
        return this.schoolRepository.findAll()
                .stream()
                .map(school -> this.mapper.toSchoolForAdminDto(school))
                .collect(Collectors.toList());
    }


    /**
     * Save a student.
     *
     * @param studentDto
     * @return a student
     */
    public StudentForAdminDto saveStudent(final StudentDto studentDto) {
        Student newStudent = this.mapper.maps(studentDto);
        Integer nouveauId = new Random().nextInt();
        newStudent.setId(nouveauId);

        Student studentSaved = this.studentRepository.save(newStudent);
        return this.mapper.toStudentForAdminDto(studentSaved);
    }

    /**
     * To find all the students.
     * @return a list of student.
     */
    public List<StudentPublicDataDto> findStudents() {
        return this.studentRepository.findAll()
                .stream()
                .map(this.mapper::toStudentPublicDataDto)
                .collect(Collectors.toList());
    }

    /**
     * Update the student informations.
     * @param studentDto
     * @param studentId
     * @return new informations of the student.
     */
    public StudentDto updateStudent(final StudentDto studentDto, final Integer studentId) {
        Student student = this.studentRepository.findById(studentId).orElseThrow(() -> {
            return new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Student with id " + studentId + " does not exist"
            );
        });

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());

        Student studentSaved = this.studentRepository.save(student);
        return this.mapper.maps(studentSaved);
    }

    /**
     * Remove of a student.
     * @param studentId
     * @return the student we removed.
     */
    public StudentDto removeStudent(final Integer studentId) {
        Student removeStudent = this.studentRepository.findById(studentId).orElse(null);
        this.studentRepository.deleteById(studentId);
        return this.mapper.maps(removeStudent);
    }

}
















