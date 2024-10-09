package training.backend.demo.student_school.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "school_tbl")
public class School {
    @Id
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @Column(name = "headmaster")
    private String headmaster;

    /**
     * Unidirectionnal relationship betwen student and school
     * Student is owner of the relationship
     */
    @OneToMany(mappedBy = "school")
    private Collection<Student> students;
}
