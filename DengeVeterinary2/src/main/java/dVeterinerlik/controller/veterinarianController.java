/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.VeterinarianFacadeImplLocal;
import dVeterinerlik.entity.Veterinarian;
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
public class veterinarianController implements Serializable {

    @EJB
    private VeterinarianFacadeImplLocal veterinarianDAO;

    private Veterinarian veterinarian;

    private List<Veterinarian> veterinarianList;

    public void clearForm() {
        this.veterinarian = new Veterinarian();
    }

    public String back() {
        this.clearForm();
        return "/admin/veterinarian/list?faces-redirect=true ";
    }

    public String createForm() {
        this.veterinarian = new Veterinarian();
        return "/admin/veterinarian/create?faces-redirect=true ";
    }

    public String updateForm(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
        return "/admin/veterinarian/update?faces-redirect=true ";
    }

    public String update() {
        veterinarianDAO.edit(this.veterinarian);
        this.veterinarian = new Veterinarian();
        return "/admin/veterinarian/list?faces-redirect=true ";
    }

    public void deleteConfirm(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public String delete(Veterinarian veterinarian) {
        veterinarianDAO.remove(veterinarian);
        this.clearForm();
        return "/admin/veterinarian/list?faces-redirect=true ";
    }

    public String create() {
        veterinarianDAO.create(this.veterinarian);
        this.clearForm();
        return "/admin/veterinarian/list?faces-redirect=true ";
    }

    public Veterinarian getVeterinarian() {
        if (this.veterinarian == null) {
            this.veterinarian = new Veterinarian();
        }
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public List<Veterinarian> getVeterinarianList() {
        this.veterinarianList = this.veterinarianDAO.findAll();
        return veterinarianList;
    }

    public void setVeterinarianList(List<Veterinarian> veterinarianList) {
        this.veterinarianList = veterinarianList;
    }
}
