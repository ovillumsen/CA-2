/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Person;
import Interface.IPersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thesoap
 */
public class PersonFacade implements IPersonFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2");

    public boolean addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.close();
        return true;
    }

    public Person getPerson(int ID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, ID);
        em.close();
        return p;
    }

    public List<Person> getPersons() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        int i = 0;
        List<Person> PL = new ArrayList();
        while (true) {
            Person p = em.find(Person.class, i);
            if (p != null) {
                PL.add(p);
                i++;
            } else {
                break;
            }
        }
        return PL;
    }

    public List<Person> getPersons(int zipcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean deletePerson(int ID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, ID);
        if (p != null) {
            em.remove(p);
            em.getTransaction().commit();
            em.close();
            return true;
        } else {
            em.close();
            return false;
        }
    }

    public Boolean editPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
        return true; 
    }

}
