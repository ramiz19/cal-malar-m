/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.UsersFacadeImplLocal;
import dVeterinerlik.entity.Users;
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
public class UsersController implements Serializable {

    @EJB
    private UsersFacadeImplLocal usersDAO;

    private Users users;

    private List<Users> usersList;

    public void clearForm() {
        this.users = new Users();
    }

    public String back() {
        this.clearForm();
        return "/admin/users/list?faces-redirect=true";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/users/create?faces-redirect=true";
    }

    public String create() {
        usersDAO.create(this.users);
        this.clearForm();
        return "/admin/users/list?faces-redirect=true";
    }

    public String updateFrom(Users users) {
        this.users = users;
        return "/admin/users/update?faces-redirect=true";
    }

    public String update() {
        usersDAO.edit(this.users);
        this.clearForm();
        return "/admin/users/list?faces-redirect=true";
    }

    public void deleteConfirm(Users users) {
        this.users = users;
    }

    public String delete(Users users) {
        usersDAO.remove(users);
        this.clearForm();
        return "/admin/users/list?faces-redirect=true";
    }

    public String start() {
        this.users = new Users() ;
        return "/admin/index?faces-redirect=true";
    }
    
    public int record(){
        return usersDAO.count();
    }
    
    public Users getUsers() {
        if (this.users == null) {
            this.clearForm();
        }
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Users> getUsersList() {
        this.usersList = this.usersDAO.findAll();
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

}
