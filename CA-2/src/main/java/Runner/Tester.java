/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Entity.Address;
import Entity.Cityinfo;
import Entity.Hobby;
import Entity.Person;
import Facade.AddressFacade;
import Facade.CityinfoFacade;
import Facade.HobbyFacade;
import Facade.PersonFacade;

/**
 *
 * @author Thesoap
 */
public class Tester {

    public static void main(String[] args) {
        PersonFacade PF = new PersonFacade();
        HobbyFacade HF = new HobbyFacade();
        
        Person p = new Person();
        Hobby h = new Hobby();
        
        p.setFn("Tim");
        p.setLn("Hemmingsen");

        h.setName("Legion");
        
        PF.addPerson(p);
        Person f =  new Person();
        f.setFn("Bliv");
        f.setLn("haps");
        PF.addPerson(f);
    }
}
