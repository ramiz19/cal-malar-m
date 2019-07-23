/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.DriverFacadeImplLocal;
import dVeterinerlik.entity.Driver;
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
public class DriverController implements Serializable {

   @EJB
    private DriverFacadeImplLocal driverDAO;

    private Driver driver;

    private List<Driver> driverList;

    public void clearForm() {
        this.driver = new Driver();
    }

    public String back() {
        this.clearForm();
        return "/admin/driver/list?faces-redirect=true ";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/driver/create?faces-redirect=true ";
    }

    public String create() {
        driverDAO.create(this.driver);
        this.clearForm();
        return "/admin/driver/list?faces-redirect=true ";
    }

    public String updateForm(Driver driver) {
        this.driver = driver;
        return "/admin/driver/update?faces-redirect=true ";
    }

    public String update() {
        driverDAO.edit(this.driver);
        this.clearForm();
        return "/admin/driver/list?faces-redirect=true ";
    }

    public void deleteConfirm(Driver driver) {
        this.driver = driver;
    }

    public String delete(Driver driver) {
        driverDAO.remove(driver);
        this.clearForm();
        return "/admin/driver/list?faces-redirect=true ";
    }

    public Driver getDriver() {
        if (this.driver == null) {
            this.driver = new Driver();
        }
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Driver> getDriverList() {
        this.driverList = this.driverDAO.findAll();
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

}
