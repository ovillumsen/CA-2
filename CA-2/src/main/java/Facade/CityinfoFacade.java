/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Cityinfo;
import Interface.ICityinfoFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Thesoap
 */
public class CityinfoFacade implements ICityinfoFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2");

    @Override
    public boolean addCityinfo(Cityinfo CI) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(CI);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean deleteCityinfo(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
