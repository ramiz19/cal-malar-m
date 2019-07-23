/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.VehicleMaintenanceFacadeImplLocal;
import dVeterinerlik.entity.VehicleMaintenance;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class VehicleMaintenanceFacadeImpl extends BaseFacade<VehicleMaintenance> implements VehicleMaintenanceFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public VehicleMaintenanceFacadeImpl() {
        super(VehicleMaintenance.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
