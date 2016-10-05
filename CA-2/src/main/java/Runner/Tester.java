/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runner;

import Entity.Address;
import Entity.Cityinfo;
import Entity.Person;
import Facade.AddressFacade;
import Facade.CityinfoFacade;
import Facade.PersonFacade;

/**
 *
 * @author Thesoap
 */
public class Tester {

    public static void main(String[] args) {
        PersonFacade PF = new PersonFacade();
        CityinfoFacade CIF =  new CityinfoFacade();
        AddressFacade AF = new AddressFacade();
        Person p = new Person();
        Address address = new Address();
        
        p.setFn("Hello");
        p.setLn("Harrow");

        
        Cityinfo CI = new Cityinfo();
        CI.setZipCode("2770");
        CI.setCity("Kastrup");
        address.setCi(CI);
        address.IE.add(p);
        CI.AL.add(address);
        CIF.addCityinfo(CI);
        

//        AF.addAddress(address);
        
        
//        p.setAddress(address);
//        Person f =  new Person();
//        f.setId(1);
//        f.setFn("Bliv");
//        f.setLn("haps");
//        PF.editPerson(f);
    }
}
