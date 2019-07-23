/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.VehicleMaintenanceFacadeImplLocal;
import dVeterinerlik.entity.VehicleMaintenance;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Alaa SHATTI
 */
@Named
@SessionScoped
public class VehicleMaintenanceController implements Serializable {

    @EJB
    private VehicleMaintenanceFacadeImplLocal vehicleMaintenanceDAO;

    private VehicleMaintenance vehicleMaintenance;

    private List<VehicleMaintenance> vehicleMaintenanceList;
    
    public void clearForm() {
        this.vehicleMaintenance = new VehicleMaintenance();
    }

    public String back() {
        this.vehicleMaintenance = new VehicleMaintenance();
        return "/admin/vehicleMaintenance/list?faces-redirect=true ";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/vehicleMaintenance/create?faces-redirect=true ";
    }

    public String updateForm(VehicleMaintenance vehicleMaintenance) {
        this.vehicleMaintenance = vehicleMaintenance;
        return "/admin/vehicleMaintenance/update?faces-redirect=true ";
    }

    public String update() {
        vehicleMaintenanceDAO.edit(this.vehicleMaintenance);
        this.vehicleMaintenance = new VehicleMaintenance();
        return "/admin/vehicleMaintenance/list?faces-redirect=true ";
    }

    public void deleteConfirm(VehicleMaintenance vehicleMaintenance) {
        this.vehicleMaintenance = vehicleMaintenance;
    }

    public String delete(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceDAO.remove(vehicleMaintenance);
        this.clearForm();
        return "/admin/vehicleMaintenance/list?faces-redirect=true ";
    }

    public String create() {
        vehicleMaintenanceDAO.create(this.vehicleMaintenance);
        this.clearForm();
        return "/admin/vehicleMaintenance/list?faces-redirect=true ";
    }

    public VehicleMaintenance getVehicleMaintenance() {
        if (this.vehicleMaintenance == null) {
            this.vehicleMaintenance = new VehicleMaintenance();
        }
        return vehicleMaintenance;
    }

    public void setVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        this.vehicleMaintenance = vehicleMaintenance;
    }

    public List<VehicleMaintenance> getVehicleMaintenanceList() {
        this.vehicleMaintenanceList = this.vehicleMaintenanceDAO.findAll();
        return vehicleMaintenanceList;
    }

    public void setVehicleMaintenanceList(List<VehicleMaintenance> vehicleMaintenanceList) {
        this.vehicleMaintenanceList = vehicleMaintenanceList;
    }

}
