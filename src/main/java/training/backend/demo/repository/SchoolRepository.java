package training.backend.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.backend.demo.entity.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}