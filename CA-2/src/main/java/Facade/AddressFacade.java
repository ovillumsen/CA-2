/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Address;
import Entity.InfoEntity;
import Entity.Person;
import Interface.IAddressFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thesoap
 */
public class AddressFacade implements IAddressFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2");

    @Override
    public boolean addAddress(Address address) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean deleteAddress(Address address) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address a = em.find(Address.class, address.getId());
        if (a != null) {
            em.remove(a);
            em.getTransaction().commit();
            em.close();
            return true;
        } else {
            em.close();
            return false;
        }
    }

    @Override
    public boolean editAddress(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address getAddress(InfoEntity IE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
