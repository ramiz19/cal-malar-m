/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.SecretaryFacadeImplLocal;
import dVeterinerlik.entity.Secretary;
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
public class SecretaryController implements Serializable {

    @EJB
    private SecretaryFacadeImplLocal secretaryDAO;

    private Secretary secretary;

    private List<Secretary> secretaryList;

    void clearForm() {
        this.secretary = new Secretary();
    }

    public String back() {
        this.clearForm();
        return "/admin/secretary/list?faces-redirect=true";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/secretary/create?faces-redirect=true";
    }

    public String create() {
        secretaryDAO.create(this.secretary);
        this.clearForm();
        return "/admin/secretary/list?faces-redirect=true";
    }

    public String updateForm(Secretary secretary) {
        this.secretary = secretary;
        return "/admin/secretary/update?faces-redirect=true";
    }

    public String update() {
        secretaryDAO.edit(this.secretary);
        this.clearForm();
        return "/admin/secretary/list?faces-redirect=true";
    }

    public void deleteConfrim(Secretary secretary) {
        this.secretary = secretary;
    }

    public String delete(Secretary secretary) {
        secretaryDAO.remove(secretary);
        this.clearForm();
        return "/admin/secretary/list?faces-redirect=true";
    }

    public Secretary getSecretary() {
        if (this.secretary == null) {
            this.secretary = new Secretary();
        }
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public List<Secretary> getSecretaryList() {
        this.secretaryList = this.secretaryDAO.findAll();
        return secretaryList;
    }

    public void setSecretaryList(List<Secretary> secretaryList) {
        this.secretaryList = secretaryList;
    }

}
