package com.domainmodule.Controller;

import com.domainmodule.Bean.Domain;
import com.domainmodule.DAO.DAOImplementation.DomainDAOImpl;
import com.domainmodule.DAO.DomainDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/domain")
public class DomainController {
    DomainDAO domDAO = new DomainDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_dom(Domain dom){
        System.out.printf(String.valueOf(dom));
        if(domDAO.addDomain(dom)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding domain").build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomainList(){
        List<Domain> doms = domDAO.getDomainList();
        System.out.printf("Hello world");
        return Response.status(200).entity(doms).build();
    }

    @GET
    @Path("/get/{d_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response get_employee(@PathParam("d_id") int id){
        System.out.println(id);

        Domain domObj = this.domDAO.getDomainById(id);
//        emp.setDepartment(emp.getDepartment());
        System.out.println(domObj);

        return Response.status(200).entity(domObj).build();
    }

    @POST
    @Path("/updateProgram/{d_id}/{p_name}")
    public Response update_program(@PathParam("d_id") int dId, @PathParam("p_name") String pName){
        System.out.println(dId + " " + pName);
        if(domDAO.updateDomainProgram(dId, pName)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(404).entity("Failure while updating domain's programme name").build();
    }

    @POST
    @Path("/updateCapacity/{d_id}/{capacity}")
    public Response update_capacity(@PathParam("d_id") int dId, @PathParam("capacity") int cap){
        System.out.println(dId + " " + cap);
        if(domDAO.updateDomainCapacity(dId, cap)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(404).entity("Failure while updating domain's capacity").build();
    }

    @POST
    @Path("/updateQualification/{d_id}/{d_qualification}")
    public Response update_qualification(@PathParam("d_id") int dId, @PathParam("d_qualification") String dQuali){
        System.out.println(dId + " " + dQuali);
        if(domDAO.updateDomainQualification(dId, dQuali)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(404).entity("Failure while updating domain's qualification").build();
    }

    @POST
    @Path("/updateBatch/{d_id}/{d_batch}")
    public Response update_batch(@PathParam("d_id") int dId, @PathParam("d_batch") String dBatch){
        System.out.println(dId + " " + dBatch);
        if(domDAO.updateDomainBatch(dId, dBatch)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(404).entity("Failure while updating domain's batch").build();
    }

}

