/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.GroupsFacadeImplLocal;
import dVeterinerlik.entity.Groups;
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
public class GroupsController implements Serializable {

    @EJB
    private GroupsFacadeImplLocal groupsDAO;

    private Groups groups;

    private List<Groups> groupsList;

    public void clearForm() {
        this.groups = new Groups();
    }

    public String back() {
        this.clearForm();
        return "/admin/groups/list?faces-redirct=true";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/groups/create?faces-redirct=true";
    }

    public String create() {
        groupsDAO.create(this.groups);
        return "/admin/groups/list?faces-redirct=true";
    }

    public String updateForm(Groups groups) {
        this.groups = groups;
        return "/admin/groups/update?faces-redirect-true";
    }

    public String update() {
        groupsDAO.edit(this.groups);
        return "/admin/groups/list?faces-redirct=true";
    }

    public void deleteConfirm(Groups groups) {
        this.groups = groups;
    }

    public String delete(Groups groups) {
        groupsDAO.remove(groups);
        return "/admin/groups/list?faces-redirct=true";
    }

    public Groups getGroups() {
        if (this.groups == null) {
            this.groups = new Groups();
        }
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public List<Groups> getGroupsList() {
        this.groupsList = this.groupsDAO.findAll();
        return groupsList;
    }

    public void setGroupsList(List<Groups> groupsList) {
        this.groupsList = groupsList;
    }

}
