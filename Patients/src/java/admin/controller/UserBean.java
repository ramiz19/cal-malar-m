/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.UserDao;
import entity.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "userbean")
@SessionScoped

public class UserBean implements Serializable {

    private User user2;
    private UserDao userdao2;
    private List<User> userlist2;

    @Inject
    private RoleBean roleBean;

    @Inject
    private DoktorBean doktorBean;

    //////////////////////////////////////////////////////pagenation
    private int page = 1;
    private int listItemCount = 10;

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int toplamKayit;
        toplamKayit = this.getUserdao2().kayitSay();

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
    //////////////////////////////////////////////////////pagenation

    public int sayi() {
        return this.getUserdao2().kayitSay();
    }

    public String createForm() {
        this.user2 = new User();
        return "/admin/user/create?faces-redirect=true";
    }

    public String create() {
        this.getUserdao2().insert(this.user2);
        return "/admin/user/list?faces-redirect=true";
    }

    public String delete(User userdelete) {
        this.getUserdao2().delete(userdelete);
        return "/admin/user/list?faces-redirect=true";
    }

    public String updateForm(User userupdate) {
        this.user2 = userupdate;
        return "/admin/user/update?faces-redirect=true";
    }

    public String update() {
        this.getUserdao2().update(this.user2);
        return "/admin/user/list?faces-redirect=true";
    }

    public String detailForm(User userdetail) {
        this.user2 = userdetail;
        return "/admin/user/detail?faces-redirect=true";
    }

    public User getUser2() {
        if (this.user2 == null) {
            this.user2 = new User();
        }
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public UserDao getUserdao2() {
        if (this.userdao2 == null) {
            this.userdao2 = new UserDao();
        }
        return userdao2;
    }

    public void setUserdao2(UserDao userdao2) {
        this.userdao2 = userdao2;
    }

    public List<User> getUserlist2() {
        this.userlist2 = this.getUserdao2().findAll(page, listItemCount);

        return userlist2;
    }

    public void setUserlist2(List<User> userlist2) {
        this.userlist2 = userlist2;
    }

    public DoktorBean getDoktorBean() {
        return doktorBean;
    }

    public void setDoktorBean(DoktorBean doktorBean) {
        this.doktorBean = doktorBean;
    }

    public RoleBean getRoleBean() {
        return roleBean;
    }

    public void setRoleBean(RoleBean roleBean) {
        this.roleBean = roleBean;
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
