/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.VererinaryFacadeImplLocal;
import dVeterinerlik.entity.Veterinary;
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
public class VeterinaryController implements Serializable {

    @EJB
    private VererinaryFacadeImplLocal veterinaryDAO;

    private Veterinary veterinary;

    private List<Veterinary> veterinaryList;

    public void clearForm() {
        this.veterinary = new Veterinary();
    }

    public String back() {
        this.clearForm();
        return "/admin/veterinary/list?faces-redirect=true";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/veterinary/create?faces-redirect=true ";
    }

    public String create() {
        veterinaryDAO.create(this.veterinary);
        this.clearForm();
        return "/admin/veterinary/list?faces-redirect=true";
    }

    public String updateForm(Veterinary veterinary) {
        this.veterinary = veterinary;
        //this.clearForm();
        return "/admin/veterinary/update?faces-redirect=true";
    }

    public String update() {
        veterinaryDAO.edit(this.veterinary);
        return "/admin/veterinary/list?faces-redirect=true";
    }

    public void deleteConfirm(Veterinary veterinary) {
        this.veterinary = veterinary;
    }

    public String delete(Veterinary veterinary) {
        veterinaryDAO.remove(veterinary);
        this.clearForm();
        return "/admin/veterinary/list?faces-redirect=true";
    }

    public Veterinary getVeterinary() {
        if (this.veterinary == null) {
            this.veterinary = new Veterinary();
        }
        return veterinary;
    }

    public void setVeterinary(Veterinary veterinary) {
        this.veterinary = veterinary;
    }

    public List<Veterinary> getVeterinaryList() {
        this.veterinaryList = this.veterinaryDAO.findAll();
        return veterinaryList;
    }

    public void setVeterinaryList(List<Veterinary> veterinaryList) {
        this.veterinaryList = veterinaryList;
    }

}
