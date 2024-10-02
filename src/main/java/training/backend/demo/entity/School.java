package training.backend.demo.entity;

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
    private String name;
    private String address;
    private String headmaster;

    /**
     * Unidirectionnal relationship betwen student and school
     * Student is owner of the relationship
     */
    @OneToMany(mappedBy = "school")
    private Collection<Student> students;
}
