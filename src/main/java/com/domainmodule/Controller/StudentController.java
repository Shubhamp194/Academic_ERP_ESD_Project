package com.domainmodule.Controller;

import com.domainmodule.Bean.Student;
import com.domainmodule.DAO.DAOImplementation.StudentDAOImpl;
import com.domainmodule.DAO.StudentDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/student")
public class StudentController {
    StudentDAO stuDAO = new StudentDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_student(Student stu){
        System.out.printf(String.valueOf(stu));
        if(stuDAO.addStudent(stu)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding department").build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentList(){
        List<Student> students = stuDAO.getStudentList();
        System.out.printf("Hello world");
        return Response.status(200).entity(students ).build();
    }
}
