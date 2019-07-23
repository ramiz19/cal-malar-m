/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.FieldmanFacadeImplLocal;
import dVeterinerlik.entity.Fieldman;
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
public class FieldmanController implements Serializable {

    @EJB
    private FieldmanFacadeImplLocal fieldmanDAO;

    private Fieldman fieldman;

    private List<Fieldman> fieldmanList;

    public void clearForm() {
        this.fieldman = new Fieldman();
    }

    public String back() {
        this.clearForm();
        return "/admin/fieldman/list?faces-redirect=true";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/fieldman/create?faces-redirect=true";
    }

    public String create() {
        fieldmanDAO.create(this.fieldman);
        this.clearForm();
        return "/admin/fieldman/list?faces-redirect=true";
    }

    public void deleteConfirm(Fieldman fieldman) {
        this.fieldman = fieldman;
    }

    public String delete(Fieldman fieldman) {
        fieldmanDAO.remove(fieldman);
        this.clearForm();
        return "/admin/fieldman/list?faces-redirect=true";
    }

    public String updateForm(Fieldman fieldman) {
        this.fieldman = fieldman;
        return "/admin/fieldman/update?faces-redirect=true";
    }

    public String update() {
        fieldmanDAO.edit(this.fieldman);
        this.clearForm();
        return "/admin/fieldman/list?faces-redirect=true";
    }

    public Fieldman getFieldman() {
        if (this.fieldman == null) {
            this.fieldman = new Fieldman();
        }
        return fieldman;
    }

    public void setFieldman(Fieldman fieldman) {
        this.fieldman = fieldman;
    }

    public List<Fieldman> getFieldmanList() {
        this.fieldmanList = this.fieldmanDAO.findAll();
        return fieldmanList;
    }

    public void setFieldmanList(List<Fieldman> fieldmanList) {
        this.fieldmanList = fieldmanList;
    }

}
