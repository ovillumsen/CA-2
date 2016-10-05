/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Hobby;
import Interface.IHobbyFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thesoap
 */
public class HobbyFacade implements IHobbyFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2");

    @Override
    public boolean addHobby(Hobby hobby) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(hobby);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean deleteHobby(Hobby hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editHobby(Hobby hobby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
