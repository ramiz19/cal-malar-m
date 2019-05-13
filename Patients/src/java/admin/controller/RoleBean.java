/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.RoleDao;
import entity.UserRole;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "rolebean")
@SessionScoped
public class RoleBean implements Serializable {

    private UserRole role1;
    private RoleDao roledao1;
    private List<UserRole> roleList1;

    private int page = 1;
    private int listItemCount = 10;

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int toplamKayit;
        toplamKayit = this.getRoledao1().kayitSay();

        if ((this.page * this.listItemCount) >= toplamKayit) {
            return false;
        } else {
            return true;
        }
    }

    public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }

    public int sayi() {
        return this.getRoledao1().kayitSay();
    }

    public String createForm() {
        this.role1 = new UserRole();
        return "/admin/user_role/create?faces-redirect=true";
    }

    public String create() {
        this.getRoledao1().insert(this.role1);
        return "/admin/user_role/list?faces-redirect=true";
    }

    public String delete(UserRole roledelete) {
        this.getRoledao1().delete(roledelete);
        return "/admin/user_role/list?faces-redirect=true";
    }

    public String updateForm(UserRole roleupdate) {
        this.role1 = roleupdate;
        return "/admin/user_role/update?faces-redirect=true";
    }

    public String update() {
        this.getRoledao1().update(this.role1);
        return "/admin/user_role/list?faces-redirect=true";

    }

    public String detailForm(UserRole roledetail) {
        this.role1 = roledetail;
        return "/admin/user_role/detail?faces-redirect=true";
    }

    public UserRole getRole1() {
        if (this.role1 == null) {
            this.role1 = new UserRole();
        }
        return role1;
    }

    public void setRole1(UserRole role1) {
        this.role1 = role1;
    }

    public RoleDao getRoledao1() {
        if (this.roledao1 == null) {
            this.roledao1 = new RoleDao();
        }
        return roledao1;
    }

    public void setRoledao1(RoleDao roledao1) {
        this.roledao1 = roledao1;
    }

    public List<UserRole> getRoleList1() {
        this.roleList1 = this.getRoledao1().findAll(page, listItemCount);
        return roleList1;
    }

    public void setRoleList1(List<UserRole> roleList1) {
        this.roleList1 = roleList1;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getListItemCount() {
        return listItemCount;
    }

    public void setListItemCount(int listItemCount) {
        this.listItemCount = listItemCount;
    }

}
