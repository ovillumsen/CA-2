/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Hobby;
import Entity.Person;
import Interface.IPersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Thesoap
 */
public class PersonFacade implements IPersonFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2");

    @Override
    public Person addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            return person;
        } finally {
            em.close();
        }
    }

    @Override
    public Person getPerson(int ID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = em.find(Person.class, ID);
        em.getTransaction().commit();
        if (p != null) {
            em.close();
            return p;
        } else {
            return null;
        }
    }

//    @Override
//    public List<Person> getPersons() {
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        int i = 1;
//        List<Person> PL = new ArrayList();
//        while (true) {
//            Person p = em.find(Person.class, i);
//            if (p != null) {
//                PL.add(p);
//                i++;
//            } else {
//                break;
//            }
//        }
//        return PL;
//    }
    public List<Person> getPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class);
        return persons.getResultList();
    }

    @Override
    public List<Person> getPersons(int zipcode) {
        List<Person> PL = new ArrayList();

        return PL;
    }

    @Override
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

    @Override
    public Person editPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
        return person;
    }

    @Override
    public boolean addHobby(Hobby hobby, Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        person.hobby.add(hobby);
        hobby.person.add(person);
        em.merge(person);
        em.merge(hobby);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
