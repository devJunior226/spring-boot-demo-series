package training.backend.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import training.backend.demo.dto.SchoolDto;
import training.backend.demo.dto.SchoolForAdminDto;
import training.backend.demo.dto.StudentDto;
import training.backend.demo.dto.StudentForAdminDto;
import training.backend.demo.dto.StudentPublicDataDto;
import training.backend.demo.service.UniversityService;
import training.backend.demo.utils.ApiResponse;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UniversityController {
    private final UniversityService universityService;

    /**
     * Persist a school in the database.
     *
     * @param schoolDto
     * @return the new school we just saved.
     */
    @PostMapping("/schools")
    public ResponseEntity<SchoolForAdminDto> postSchool(@RequestBody SchoolDto schoolDto) {
        SchoolForAdminDto newSchool = universityService.saveSchool(schoolDto);
        return new ResponseEntity<>(newSchool, HttpStatus.CREATED);
    }

    /**
     * Retrieve all the schools available.
     *
     * @return a list of schools.
     */
    @GetMapping("/schools")
    public ResponseEntity<ApiResponse<List<SchoolForAdminDto>>> getSchools() {
        List<SchoolForAdminDto> schools = universityService.findSchools();
        ApiResponse<List<SchoolForAdminDto>> response = new ApiResponse<>("List of schools", schools);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Return alls the students available.
     *
     * @return a list of students
     */
    @GetMapping("/students")
    public ResponseEntity<ApiResponse<List<StudentPublicDataDto>>> getStudents() {
        List<StudentPublicDataDto> students = this.universityService.findStudents();
        ApiResponse<List<StudentPublicDataDto>> response = new ApiResponse<>("List of students", students);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Save a student.
     *
     * @param studentDto
     * @return the saved student
     */
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<StudentForAdminDto>> postSudent(@RequestBody final StudentDto studentDto) {
        StudentForAdminDto studentPosted = this.universityService.saveStudent(studentDto);
        ApiResponse<StudentForAdminDto> response = new ApiResponse<>("You saved a student", studentPosted);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * We update student informations.
     *
     * @param id
     * @param studentDto
     * @return the student we just updated.
     */
    @PutMapping("/students/{id}")
    public ResponseEntity<ApiResponse<StudentDto>> putStudent(
            @PathVariable final Integer id,
            @RequestBody final StudentDto studentDto) {
        StudentDto studentEdited = this.universityService.updateStudent(studentDto, id);
        ApiResponse<StudentDto> response = new ApiResponse<>("You updated a student", studentEdited);

        return ResponseEntity.ok().body(response);
    }

    /**
     * Delete the student.
     *
     * @param id
     * @return the student deleted.
     */
    @DeleteMapping("/students/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable final Integer id) {
        StudentDto studentDeleted = this.universityService.removeStudent(id);
        ApiResponse<String> response = new ApiResponse<>("Student deleted : ", studentDeleted.getLastName());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
