/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Cityinfo;

/**
 *
 * @author Thesoap
 */
public interface ICityinfoFacade {
    boolean addCityinfo(Cityinfo CI);
    boolean deleteCityinfo(int ID);
}
