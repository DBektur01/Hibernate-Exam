package Java13.dao;

import Java13.entity.Course;
import Java13.entity.Student;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface CourseDao {
    String createCourse(Course course);

    Course getCourseById(Long courseId);

    String updateCourse(Long courseId, Course newCourse);

    String deleteCourse(Long courseId);

    List<Student> getCourseStudents(Long courseId);

    String assignStudentToCourse(Long courseId, Long studentId);
}
