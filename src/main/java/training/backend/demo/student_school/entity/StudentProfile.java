package training.backend.demo.student_school.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_profile_tbl")
public class StudentProfile {
    @Id
    private Integer id;
    private String biography;
    @Column(name = "study_domain")
    private String studyDomain;
    private String passion;

    /** Unidirectionnal relationship betwen student and studentProfile */
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
