package Java13.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends GenerateID{
    @SequenceGenerator( name = "id_gen",  sequenceName = "course_seq",  allocationSize = 1)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(unique = true)
    private String email;
    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;
    @ManyToMany
    private List<Course> courses;

    public Student(String fullName, String email, LocalDate enrollmentDate) {
        this.fullName = fullName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
    }

    public Student(String fullName, String email, LocalDate enrollmentDate, List<Course> courses) {
        this.fullName = fullName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
