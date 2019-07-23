/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.DriverFacadeImplLocal;
import dVeterinerlik.entity.Driver;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class DriverFacadeImpl extends BaseFacade<Driver> implements DriverFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public DriverFacadeImpl() {
        super(Driver.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
