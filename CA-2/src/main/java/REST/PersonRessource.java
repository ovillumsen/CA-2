/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Entity.Person;
import Facade.PersonFacade;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ejer
 */
@Path("person")
public class PersonRessource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonRessource
     */
    public PersonRessource() {
    }

    /**
     * Retrieves representation of an instance of REST.PersonRessource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") int id) {
        Gson gson = new com.google.gson.GsonBuilder().create();
        JsonObject person = new JsonObject();
        PersonFacade PF = new PersonFacade();
        Person p = PF.getPerson(id);
        person.addProperty("Firstname", p.getFn());
        person.addProperty("Firstname", p.getLn());
        String jsonRes = gson.toJson(person);
        String lort = p.getFn()+ " " +p.getLn();
        return jsonRes;
    }

    /**
     * PUT method for updating or creating an instance of PersonRessource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
