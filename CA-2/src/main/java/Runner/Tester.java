/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Entity.Person;
import Facade.PersonFacade;

/**
 *
 * @author Thesoap
 */
public class Tester {
    public static void main(String[] args) {
        PersonFacade PF =  new PersonFacade();
        Person p = new Person();
        p.setFn("Hello");
        p.setLn("Harrow");
        PF.addPerson(p);
        Person f =  new Person();
        f.setId(1);
        f.setFn("Bliv");
        f.setLn("haps");
        PF.editPerson(f);
    }
}
