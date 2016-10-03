/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Person;
import Interface.IPersonFacade;
import java.util.List;

/**
 *
 * @author Thesoap
 */
public class PersonFacade implements IPersonFacade {

    public boolean addPerson(Person person) {
        return true;
    }

    public Person getPerson(int ID) {
        Person p = new Person();
        return p;
    }

    public List<Person> getPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Person> getPersons(int zipcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean deletePerson(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean editPerson(Person person, int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
