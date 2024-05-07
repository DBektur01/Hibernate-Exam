package Java13.service;

import Java13.entity.Course;
import Java13.entity.Student;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface StudentService {
    String createStudent(Student student);

    Student getStudentById(Long studentId);

    String updateStudentName(Long studentId, String newName);

    String deleteStudent(Long studentId);

    List<Course> getStudentCourses(Long studentId);

    List<Student> getStudentsByRecentEnrollments(int limit);
}
