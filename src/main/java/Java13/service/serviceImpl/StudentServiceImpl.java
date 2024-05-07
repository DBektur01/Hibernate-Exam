package Java13.service.serviceImpl;

import Java13.dao.StudentDao;
import Java13.entity.Course;
import Java13.entity.Student;
import Java13.service.StudentService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    @Override
    public String createStudent(Student student) {
        return studentDao.createStudent(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public String updateStudentName(Long studentId, String newName) {
        return studentDao.updateStudentName(studentId, newName);
    }

    @Override
    public String deleteStudent(Long studentId) {
        return studentDao.deleteStudent(studentId);
    }

    @Override
    public List<Course> getStudentCourses(Long studentId) {
        return studentDao.getStudentCourses(studentId);
    }

    @Override
    public List<Student> getStudentsByRecentEnrollments(int limit) {
        return studentDao.getStudentsByRecentEnrollments(limit);
    }
}
