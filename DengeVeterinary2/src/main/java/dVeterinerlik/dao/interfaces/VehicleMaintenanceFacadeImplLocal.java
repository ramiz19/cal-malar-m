/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.VehicleMaintenance;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface VehicleMaintenanceFacadeImplLocal {

    public List<VehicleMaintenance> findAll();

    public void edit(VehicleMaintenance obj);

    public void remove(VehicleMaintenance obj);

    public void create(VehicleMaintenance obj);

    VehicleMaintenance find(Object id);

}
