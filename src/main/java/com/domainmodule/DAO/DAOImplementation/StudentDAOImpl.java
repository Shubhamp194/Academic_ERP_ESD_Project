package com.domainmodule.DAO.DAOImplementation;

import com.domainmodule.Bean.Domain;
import com.domainmodule.Bean.Student;
import com.domainmodule.DAO.StudentDAO;
import com.domainmodule.Util.HibernateSessionUtil;
import org.hibernate.query.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student stuObj) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(stuObj);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch (Exception e){
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

//    @Override
//    public Student getStudentById(int stuId) {
//        try (Session session = HibernateSessionUtil.getSession()) {
//            return session.get(Student.class, stuId);
//        } catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//        }
//        return null;
//    }

    @Override
    public List<Student> getStudentList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Student> studentList = new ArrayList<>();
            for (final Object d : session.createQuery("from Student ").list()) {
                studentList.add((Student) d);
            }
            return studentList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Student> getStudentByDomain(Domain domain) {
        List<Student> students = new ArrayList<Student>();

        try (Session session = HibernateSessionUtil.getSession()){

            Query query = session.createQuery("from Student where domain.domain_id =:domain");
            query.setParameter("domain", domain.getDomain_id());
//
            for ( Object fetch: query.list()) {

                Student student = (Student) fetch;
                students.add(student);

            }
            return students;
        }
    }

//    public List<Students> getStudents(Courses course) {
//
//        List<Students> students = new ArrayList<Students>();
//
//        try (Session session = SessionUtil.getSession()){
//
//            Query query = session.createQuery("from Courses where course_id =: course_id");
//            query.setParameter("course_id", course.getCourse_id());
//
//            for (final Object fetch: query.list()) {
//
//                course = (Courses) fetch;
//                List<StudentCourses> studentCoursesList = course.getStudentCoursesList();
//                for(StudentCourses studentCourses: studentCoursesList) {
//                    students.add(studentCourses.getStudent_id());
//                }
//            }
//            return students;
//        }
}
