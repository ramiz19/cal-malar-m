/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.UserDao;
import entity.User;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import utility.SessionUtility;

/**
 *
 * @author cypher
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean implements Serializable {

    private User user;
    private UserDao userDao;
    private boolean loggedIn = false;
    //private String username;
    //private String password;

    public String loginFRONT() {

        User ab = this.getUserDao().login2(this.user);

        if (ab != null) {
            this.loggedIn = true;
            HttpSession session = SessionUtility.getSession();
            session.setAttribute("user", ab);

            return "/frontend/index?faces-redirect=true";

        } else {
            return "/login?faces-redirect=true";
        }

    }

    public String loginAdmin() {

        User aa = this.getUserDao().login2(this.user);

        if (aa != null) {
            this.loggedIn = true;
            HttpSession session = SessionUtility.getSession();
            session.setAttribute("user", aa);
            return "/admin/index?faces-redirect=true";

        } else {
            return "/login?faces-redirect=true";
        }

    }

    public boolean varmi() {
        if (this.user == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public String goRegister(){
    
        return "/register?faces-redirect=true";
    }
    

    public String doLogout() {

        this.setLoggedIn(false);
        this.user = null;
        //this.password = null;

        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "/index?faces-redirect=true";

    }

    public User usesss() {

        return this.user;
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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.loggedIn = isLoggedIn;
    }

}
