/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Hobby;
import Entity.Person;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thesoap
 */
public class PersonFacadeTest {

    PersonFacade PF = new PersonFacade();

    public PersonFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        PersonFacade PF = new PersonFacade();
        Person p1 = new Person();
        p1.setFn("Tim");
        p1.setLn("Hemmingsen");
        Person p2 = new Person();
        p2.setFn("Oliver");
        p2.setLn("Villumsen");
        PF.addPerson(p1);
        PF.addPerson(p2);
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

    /**
     * Test of addPerson method, of class PersonFacade.
     */
    @Test
    public void testAddPerson() {
        Person person = new Person();
        Person expResult = new Person();

        expResult.setFn("Hello");
        expResult.setLn("Harrow");
        expResult.setId(3);

        person.setFn("Hello");
        person.setLn("Harrow");
        PF.addPerson(person);
        assertEquals(expResult.getId(), person.getId());
    }

    /**
     * Test of getPerson method, of class PersonFacade.
     */
    @Test
    public void testGetPerson() {
        Person result = PF.getPerson(2);
        Person expResult = new Person();
        expResult.setFn("Oliver");
        assertEquals(expResult.getFn(), result.getFn());
    }

    /**
     * Test of getPersons method, of class PersonFacade.
     */
    @Test
    public void testGetPersons_0args() {
        System.out.println("getPersons");
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersons method, of class PersonFacade.
     */
    @Test
    public void testGetPersons_int() {
        System.out.println("getPersons");
        int zipcode = 0;
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons(zipcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePerson method, of class PersonFacade.
     */
    @Test
    public void testDeletePerson() {
        boolean result = PF.deletePerson(1);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of editPerson method, of class PersonFacade.
     */
    @Test
    public void testEditPerson() {
        System.out.println("editPerson");
        Person person = null;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.editPerson(person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addHobby method, of class PersonFacade.
     */
    @Test
    public void testAddHobby() {
        System.out.println("addHobby");
        Hobby hobby = null;
        Person person = null;
        PersonFacade instance = new PersonFacade();
        boolean expResult = false;
        boolean result = instance.addHobby(hobby, person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
