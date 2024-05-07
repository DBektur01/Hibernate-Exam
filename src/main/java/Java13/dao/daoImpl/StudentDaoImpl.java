package Java13.dao.daoImpl;

import Java13.config.DatabaseConfig;
import Java13.dao.StudentDao;
import Java13.entity.Course;
import Java13.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class StudentDaoImpl implements StudentDao {
    private final EntityManagerFactory entityManagerFactory = DatabaseConfig.entityManagerFactory();
    @Override
    public String createStudent(Student student) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            return "Student successfully created!";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public Student getStudentById(Long studentId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            return entityManager.find(Student.class, studentId);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateStudentName(Long studentId, String newName) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Student student = entityManager.find(Student.class, studentId);
            student.setFullName(newName);
            entityManager.merge(student);
            entityManager.getTransaction().commit();
            return "Student successfully updated!";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteStudent(Long studentId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Student student = entityManager.find(Student.class, studentId);
            entityManager.getTransaction().begin();
            entityManager.remove(student);
            entityManager.getTransaction().commit();
            return "Student successfully deleted!";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Course> getStudentCourses(Long studentId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Student student = entityManager.find(Student.class, studentId);
            return student.getCourses();
        } catch (HibernateException e) {
            System.out.println();
            return null;
        }
    }

    @Override
    public List<Student> getStudentsByRecentEnrollments(int limit) {
        String hql = "select s from Student s order by enrollmentDate desc limit :limit";
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery(hql).setParameter("limit", limit).getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
