/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Person;
import Entity.Phone;
import java.util.List;

/**
 *
 * @author Thesoap
 */
public interface IPersonFacade {
    Person addPerson(Person person, Phone phone); 
    Person getPerson(int ID);
    List<Person> getPersons();
    List<Person> getPersons(int zipcode);
    Boolean deletePerson(int ID);
    Boolean editPerson(Person person);
}
