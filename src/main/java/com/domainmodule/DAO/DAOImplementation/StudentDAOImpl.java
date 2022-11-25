package com.domainmodule.DAO.DAOImplementation;

import com.domainmodule.Bean.Student;
import com.domainmodule.DAO.StudentDAO;
import com.domainmodule.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student stuObj) {
        try(Session session = HibernateSessionUtil.getSession()){  // sessin created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(stuObj);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
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

    @Override
    public Student getStudentById(int stuId) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Student.class, stuId);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

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
}
