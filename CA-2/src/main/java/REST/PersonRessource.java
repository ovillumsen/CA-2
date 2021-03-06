package REST;

import Entity.Person;
import Facade.PersonFacade;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("person")
public class PersonRessource {

    static Gson gson = new Gson();
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
//        String person1 = p.getFn() + p.getLn();
        return jsonRes;
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getAllPerson(){
//        Gson gson = new com.google.gson.GsonBuilder().create();
//        JsonArray array = new JsonArray();
//        PersonFacade PF = new PersonFacade();
//        for (int i = 0; i < array.size(); i++) {
//            Person p = PF.getPerson(i);
//            array.add(p.getFn());
//            array.add(p.getLn());
//        }
//        String jsonRes = gson.toJson(array);
//        return jsonRes;
//    }
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPerson() {
        PersonFacade PF = new PersonFacade();
        Gson gson = new com.google.gson.GsonBuilder().create();
        return gson.toJson(PF.getPersons());
    }

//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getPersonInfo(@PathParam("id") int id){
//        PersonFacade PF = new PersonFacade();
//        PF.
//    }
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addPerson(String text) {
        Person p = gson.fromJson(text, Person.class);
        PersonFacade pf = new PersonFacade();
        Person np = pf.addPerson(p);
        return gson.toJson(np);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        
    }
}
