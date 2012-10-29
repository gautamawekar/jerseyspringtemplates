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

import com.gawekar.entity.Person;
import com.gawekar.service.PersonDao;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
@Component
@Scope("request")
public class MyResource {
    @Autowired
    PersonDao personDao;

    /**
     * Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * 
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET
    @Produces("text/plain")
    public String test() {
        return "Hi there! This is person resource";
    }

    @Path("/create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Person p) {
        personDao.createPerson(p);
        return Response.ok(p).build();
    }

    @GET
    @Path("/findall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(personDao.findAll()).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deletePerson(@PathParam("id") int id) {
        personDao.deletePerson(id);
        return Response.ok("Person with id: " + id + " deleted").build();
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person p) {
        personDao.updatePerson(p);
        return Response.ok(p).build();
    }

}
