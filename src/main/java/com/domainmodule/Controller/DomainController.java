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

        return Response.status(400).entity("Failure while adding department").build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomainList(){
        List<Domain> doms = domDAO.getDomainList();
        System.out.printf("Hello world");
        return Response.status(200).entity(doms).build();
    }



}
