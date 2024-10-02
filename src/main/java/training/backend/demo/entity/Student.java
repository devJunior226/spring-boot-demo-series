package training.backend.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "student_tbl")
public class Student {
    @Id
    private Integer id;
    @Column(name = "first_name", length = 100)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private int age;

    /** Unidirectionnal relationship betwen student and studentProfile */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    //@JoinColumn(name = "student_profile_id")
    private StudentProfile studentProfile;

    /** Unidirectionnal relationship betwen student and school. */
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
