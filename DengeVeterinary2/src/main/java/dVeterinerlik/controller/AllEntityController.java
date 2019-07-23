/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.AllEntityFacadeImplLocal;
import dVeterinerlik.entity.AllEntity;
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
public class AllEntityController implements Serializable {

    @EJB

    private AllEntityFacadeImplLocal allEntityDAO;

    private AllEntity allEntity;

    private List<AllEntity> allEntityList;

    public void clearForm() {
        this.allEntity = new AllEntity();
    }

    public String back() {
        this.clearForm();
        return "/admin/allEntity/list?faces-redirct=true";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/allEntity/create?faces-redirect=true";
    }

    public String create() {
        allEntityDAO.create(this.allEntity);
        this.clearForm();
        return "/admin/allEntity/list?faces-redirect=true";
    }

    public String updateForm(AllEntity allEntity) {
        this.allEntity = allEntity;
        return "/admin/allEntity/update?faces-redirect=true";
    }

    public String update() {
        allEntityDAO.edit(this.allEntity);
        return "/admin/allEntity/list?faces-redirect=true";
    }

    public AllEntity getAllEntity() {
        if (this.allEntity == null) {
            this.allEntity = new AllEntity();
        }
        return allEntity;
    }

    public void setAllEntity(AllEntity allEntity) {
        this.allEntity = allEntity;
    }

    public List<AllEntity> getAllEntityList() {
        this.allEntityList = this.allEntityDAO.findAll();
        return allEntityList;
    }

    public void setAllEntityList(List<AllEntity> allEntityList) {
        this.allEntityList = allEntityList;
    }

}
