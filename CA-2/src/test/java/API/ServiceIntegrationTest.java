package API;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entity.Person;
import Facade.PersonFacade;
import REST.PersonRessource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author Oliver
 */
public class ServiceIntegrationTest {

    public ServiceIntegrationTest() {
    }

    @BeforeClass
    public static void setUpBeforeAll() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/CA-2";
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void serverIsRunning() {
        given().when().get().then().statusCode(200);
    }
    
    @Test
    public void getPerson() {
        PersonFacade PF = new PersonFacade();
        Person p = PF.getPerson(1);
                given().when().get("/api/person/{id}", 1).then().statusCode(200).
            body("Firstname",equalTo(p.getFn()))
                .body("LastName",equalTo(p.getLn()));
    }
    
    @Test
    public void getPersonWrongArguments() {
        given().when().get("/api/person/{id}", "hej").then().statusCode(404).body("code", equalTo(404));
    }
    
    @Test
    public void getPersonWrongRoute() {
        given().when().get("/api/ThisIsWrong/{id}", 1).then().statusCode(404).body("code", equalTo(404));
    }
    
    @Test
    public void getAllPersons() {
        PersonRessource PR = new PersonRessource();
        PersonFacade PF = new PersonFacade();
        given().when().get("/api/person/all").then().statusCode(200).body(PR.getAllPerson(), equalTo(PF.getPersons()));
    }
}