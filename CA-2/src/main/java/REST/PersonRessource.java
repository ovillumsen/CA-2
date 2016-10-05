package REST;

import Entity.Person;
import Facade.PersonFacade;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person/complete")
public class PersonRessource {

    @Context
    private UriInfo context;

    public PersonRessource() {
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") int id) {
        Gson gson = new com.google.gson.GsonBuilder().create();
        JsonObject person = new JsonObject();
        PersonFacade PF = new PersonFacade();
        Person p = PF.getPerson(id);
        person.addProperty("Firstname", p.getFn());
        person.addProperty("LastName", p.getLn());
        String jsonRes = gson.toJson(person);
        return jsonRes;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPerson() {
        PersonFacade PF = new PersonFacade();
        Gson gson = new com.google.gson.GsonBuilder().create();
        return gson.toJson(PF.getPersons());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(String text) {
        Gson gson = new com.google.gson.GsonBuilder().create();
        Person p = gson.fromJson(text, Person.class);
        System.out.println(p.getFn());
        //PersonFacade pf = new PersonFacade();
        JsonObject jso = new JsonObject();
        jso.addProperty("fn", p.getFn());
        jso.addProperty("ln", p.getLn());
        //pf.addPerson(p);
        return Response.status(200).entity(jso).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
