package training.backend.demo.student_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.backend.demo.student_school.entity.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}