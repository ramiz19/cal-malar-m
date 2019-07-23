/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.VehicleFacadeImplLocal;
import dVeterinerlik.entity.Vehicle;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class VehicleFacadeImpl extends BaseFacade<Vehicle> implements VehicleFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public VehicleFacadeImpl() {
        super(Vehicle.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
