/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.PermissionFacadeImplLocal;
import dVeterinerlik.dao.interfaces.UsersFacadeImplLocal;
import dVeterinerlik.entity.Groups;
import dVeterinerlik.entity.Users;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Alaa SHATTI
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private UsersFacadeImplLocal usersDAO;

    @EJB
    private PermissionFacadeImplLocal primLocalDAO;

    private Users users;

    // private List<Groups> groupList;
    private Groups groups;

  

    public String startPage() {
        return "/frontend/index.xhtml";
    }

    public boolean hasPermission(String module, String process) {
        return this.primLocalDAO.hasPerm(getGroups(), module, process);
    }

    public String login() {
        Users user = usersDAO.login(this.users.getEmail(), this.users.getPassword());
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.users);
            return "/admin/index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Mail veya Şifre Girdiniz!"));
            return "/login.xhtml";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.users = null;
        return "/index.xhtml";
    }

    public Users getUsers() {
        if (this.users == null) {
            this.users = new Users();
        }
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    /* public List<Groups> getGroupList() {
        this.groupList = usersDAO.login(this.users.getEmail(), this.users.getPassword()).getGroups();
        return groupList;
    }

    public void setGroupList(List<Groups> groupList) {
        this.groupList = groupList;
    }*/
    public Groups getGroups() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("groups", this.groups);

        return this.groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

   

}
