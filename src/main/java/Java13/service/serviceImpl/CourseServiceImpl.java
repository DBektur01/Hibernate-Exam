package Java13.service.serviceImpl;

import Java13.dao.CourseDao;
import Java13.dao.daoImpl.CourseDaoImpl;
import Java13.entity.Course;
import Java13.entity.Student;
import Java13.service.CourseService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public String createCourse(Course course) {
        return courseDao.createCourse(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        return courseDao.updateCourse(courseId, newCourse);
    }

    @Override
    public String deleteCourse(Long courseId) {
        return courseDao.deleteCourse(courseId);
    }

    @Override
    public List<Student> getCourseStudents(Long courseId) {
        return courseDao.getCourseStudents(courseId);
    }

    @Override
    public String assignStudentToCourse(Long courseId, Long studentId) {
        return courseDao.assignStudentToCourse(courseId, studentId);
    }
}
