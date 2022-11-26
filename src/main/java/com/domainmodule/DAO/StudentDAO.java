package com.domainmodule.DAO;

import com.domainmodule.Bean.Domain;
import com.domainmodule.Bean.Student;

import java.util.List;

public interface StudentDAO {
    boolean addStudent(Student stuObj);
//    Student getStudentById(int stuId);
    List<Student> getStudentList();
    List<Student> getStudentByDomain(Domain domain);
}
