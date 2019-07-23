/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.PermissionFacadeImplLocal;
import dVeterinerlik.entity.Groups;
import dVeterinerlik.entity.Users;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Alaa SHATTI
 */
@Named
@SessionScoped
public class PermissionController implements Serializable {

    @EJB
    private PermissionFacadeImplLocal permissionDAO;

    private Groups groups;

    public boolean hasPerm(String module, String process) {
        return this.permissionDAO.hasPerm(getGroups(), module, process);

    }

    /*public boolean hasPerm2(String module) {

        if (hasPerm(module, "u") || hasPerm(module, "d")) {
            return true;
        } else {
            return false;
        }
      public boolean hasPerm2(String module, String process) {

        try {

            Users current = (Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("user", null);
            boolean a;

            a = this.permissionDAO.hasPerm(current.getGroups(), module, process);

            return a;
        } catch (Exception e) {
            return false;
        }
    }
    }*/

  
    public Groups getGroups() {
        if (this.groups == null) {
            this.groups = new Groups();
        }
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

}
