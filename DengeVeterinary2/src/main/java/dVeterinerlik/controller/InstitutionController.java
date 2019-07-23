/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.InstitutionFacadeImplLocal;
import dVeterinerlik.entity.Institution;
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
public class InstitutionController implements Serializable {

    @EJB

    private InstitutionFacadeImplLocal InstitutionDAO;

    private Institution institution;

    private List<Institution> institutionList;
    
    
    public void clearForm() {
        this.institution = new Institution();
    }

    public String back() {
        this.clearForm();
        return "/admin/institution/list?faces-redirect=true ";
    }

    public String createForm() {
        this.institution = new Institution();
        return "/admin/institution/create?faces-redirect=true ";
    }

    public String updateForm(Institution institution) {
        this.institution = institution;
        return "/admin/institution/update?faces-redirect=true ";
    }

    public String update() {
        InstitutionDAO.edit(this.institution);
        this.institution = new Institution();
        return "/admin/institution/list?faces-redirect=true ";
    }

    public void deleteConfirm(Institution institution) {
        this.institution = institution;
    }

    public String delete(Institution accounting) {
        InstitutionDAO.remove(accounting);
        this.clearForm();
        return "/admin/institution/list?faces-redirect=true ";
    }

    public String create() {
        InstitutionDAO.create(this.institution);
        this.institution = new Institution();
        return "/admin/institution/list?faces-redirect=true ";
    }

    public Institution getInstitution() {
        if (this.institution == null) {
            this.institution = new Institution();
        }
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public List<Institution> getInstitutionList() {
        this.institutionList = this.InstitutionDAO.findAll();
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }

}
