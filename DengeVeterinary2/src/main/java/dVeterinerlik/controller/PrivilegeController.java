/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.PrivilegeFacadeImplLocal;
import dVeterinerlik.entity.Privilege;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Alaa SHATTI
 */
@Named
@SessionScoped
public class PrivilegeController implements Serializable {

    @EJB

    private PrivilegeFacadeImplLocal privilegeDAO;

    private Privilege privilege;

    private List<Privilege> privilegeList;

    public void clearForm() {
        this.privilege = new Privilege();
    }

    public String back() {
        this.clearForm();
        return "/admin/privilege/list?faces-redirect=true";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/privilege/create?faces-redirect=true";
    }

    public String create() {
        privilegeDAO.create(this.privilege);
        return "/admin/privilege/list?faces-redirect=true";
    }

    public String updateForm(Privilege privelege) {
        this.privilege = privelege;
        return "/admin/privilege/update?faces-redirect=true";
    }

    public String update() {
        privilegeDAO.edit(this.privilege);
        this.clearForm();
        return "/admin/privilege/list?faces-redirect=true";
    }

    public void deleteConfirm(Privilege privilege) {
        this.privilege = privilege;
    }

    public void delete(Privilege privilege) {
        privilegeDAO.remove(privilege);
        this.clearForm();
    }

    public void toggle(Privilege p, String op) {
        try {
            Method m = Privilege.class.getDeclaredMethod("is" + op);
            boolean tmp = (boolean) m.invoke(p);
            tmp = !tmp;

            m = Privilege.class.getDeclaredMethod("set" + op, boolean.class);
            m.invoke(p, tmp);
            this.privilegeDAO.edit(p);

        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PrivilegeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Privilege getPrivilege() {
        if (this.privilege == null) {
            this.privilege = new Privilege();
        }
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public List<Privilege> getPrivilegeList() {
        this.privilegeList = this.privilegeDAO.findAll();
        return privilegeList;
    }

    public void setPrivilegeList(List<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

}
