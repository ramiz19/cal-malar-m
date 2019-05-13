/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author cemr_
 */
public class User {
    private Long user_id;
    private String user_name;
    private String password;
    private String email;
    
    private UserRole role_entity;
    private Hasta hasta_entity;
    private Doktor doktor_entity;

    public User() {
    }

    public User(Long user_id, String user_name, String password, String email, UserRole role_entity) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.role_entity=role_entity;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole_entity() {
        return role_entity;
    }

    public void setRole_entity(UserRole role_entity) {
        this.role_entity = role_entity;
    }

    public Hasta getHasta_entity() {
        return hasta_entity;
    }

    public void setHasta_entity(Hasta hasta_entity) {
        this.hasta_entity = hasta_entity;
    }

    public Doktor getDoktor_entity() {
        return doktor_entity;
    }

    public void setDoktor_entity(Doktor doktor_entity) {
        this.doktor_entity = doktor_entity;
    }
    
    

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", email=" + email + ", role_entity=" + role_entity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.user_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        return true;
    }

    
    
    
}
