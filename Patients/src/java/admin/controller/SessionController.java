/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.SessionDao;
import admin.dao.UserDao;
import entity.User;
import entity.UserRole;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "sessions")
@SessionScoped
public class SessionController implements Serializable {

    private SessionDao sessionDao;

    private User user;
    private UserDao userDao;

    public boolean hasPerm(String module, String process) {

        User current = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("user", null);

        return this.getSessionDao().getPerm(current.getRole_entity(), module, process);

    }

    public boolean hasPerm2(String module) {

        if (hasPerm(module, "U") || hasPerm(module, "Del") || hasPerm(module, "D")) {
            return true;
        } else {
            return false;
        }
    }
    
    /*

    public String login() {
        User usr = this.getUserDao().login2(this.user);
        if (usr != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usr);
            return "/admin/index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("hatalı giris yapildi.."));
            return "/login?faces-redirect=true";
        }

    }

*/
    public SessionDao getSessionDao() {
        if (this.sessionDao == null) {
            this.sessionDao = new SessionDao();
        }
        return sessionDao;
    }

    public void setSessionDao(SessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUserDao() {
        if (this.userDao == null) {
            this.userDao = new UserDao();
        }
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
