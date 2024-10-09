package training.backend.demo.student_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.backend.demo.student_school.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    /**
     * Verify if the student with this email exists.
     * @param email
     * @return boolean
     */
    boolean existsByEmail(String email);
}

