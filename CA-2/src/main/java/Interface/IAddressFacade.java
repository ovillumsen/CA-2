/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Address;
import Entity.InfoEntity;

/**
 *
 * @author Thesoap
 */
public interface IAddressFacade {
    boolean addAddress(Address address);
    boolean deleteAddress(Address address);
    boolean editAddress(Address address);
    Address getAddress(InfoEntity IE);
}
