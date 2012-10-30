package com.gawekar.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gawekar.entity.Department;
import com.gawekar.service.DepartmentDao;
import com.gawekar.service.DepartmentService;

@Path("/department")
@Component
@Scope("request")
public class DepartmentResource {
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    DepartmentService deptService;

    /**
     * Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * 
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET
    @Produces("text/plain")
    public String test() {
        return "Hi there! This is department resource";
    }

    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDepartment(Department d) {
        return Response.ok(deptService.createDepartmentIfRequired(d)).build();
    }

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(departmentDao.findAll()).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteDepartment(@PathParam("id") int id) {
        departmentDao.deleteDepartment(id);
        return Response.ok("Department with id: " + id + " deleted").build();
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDepartment(Department p) {
        departmentDao.updateDepartment(p);
        return Response.ok(p).build();
    }
}
