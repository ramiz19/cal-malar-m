/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.VehicleFacadeImplLocal;
import dVeterinerlik.entity.Vehicle;
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
public class VehicleController implements Serializable {

    @EJB
    private VehicleFacadeImplLocal vehicleDAO;

    private Vehicle vehicle;

    private List<Vehicle> vehicleList;

    public void clearForm() {
        this.vehicle = new Vehicle();
    }

    public String back() {
        this.vehicle = new Vehicle();
        return "/admin/vehicle/list?faces-redirect=true ";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/vehicle/create?faces-redirect=true ";
    }

    public String updateForm(Vehicle vehicle) {
        this.vehicle = vehicle;
        return "/admin/vehicle/update?faces-redirect=true ";
    }

    public String update() {
        vehicleDAO.edit(this.vehicle);
        this.vehicle = new Vehicle();
        return "/admin/vehicle/list?faces-redirect=true ";
    }

    public void deleteConfirm(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String delete(Vehicle vehicle) {
        vehicleDAO.remove(vehicle);
        this.clearForm();
        return "/admin/vehicle/list?faces-redirect=true ";
    }

    public String create() {
        vehicleDAO.create(this.vehicle);
        this.clearForm();
        return "/admin/vehicle/list?faces-redirect=true ";
    }

    public Vehicle getVehicle() {
        if (this.vehicle == null) {
            this.vehicle = new Vehicle();
        }
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Vehicle> getVehicleList() {
        this.vehicleList = this.vehicleDAO.findAll();
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

}
