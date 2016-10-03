/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Phone;
import java.util.List;

/**
 *
 * @author Thesoap
 */
public interface IPhoneFacade {
    boolean addPhone(Phone phone);
    boolean deletePhone(Phone phone);
    boolean editPhone(Phone phone,int id);
    List<Phone> getPhones();
    Phone getPhone(Phone phone);
}
