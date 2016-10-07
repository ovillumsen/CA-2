/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Entity.Person;
import Entity.Phone;
import Facade.PersonFacade;

/**
 *
 * @author Thesoap
 */
public class Tester {
    public static void main(String[] args) {
        PersonFacade PF =  new PersonFacade();
        Person p = new Person();
        Phone ph = new Phone();
        p.setFn("Hello");
        p.setLn("Harrow");
        ph.setNr(28286825);
        ph.setDes("Bob");
        PF.addPerson(p, ph);
        Person f =  new Person();
        Phone pho = new Phone();
        f.setFn("Bliv");
        f.setLn("haps");
        pho.setNr(12345678);
        pho.setDes("Random");
        PF.addPerson(f, pho);
    }
}
