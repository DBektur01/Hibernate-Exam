package Java13.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends GenerateID {
    @SequenceGenerator(name = "id_gen", sequenceName = "course_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    @ManyToMany
    private List<Student> students;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Course(String name, String description, List<Student> students) {
        this.name = name;
        this.description = description;
        this.students = students;
    }

    @Override
    public String toString() {
        return "\nCourse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description=" + description +
                '}';
    }
}
