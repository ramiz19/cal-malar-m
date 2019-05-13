/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author cemr_
 */
public class UserRole {
    private Long role_id;
    private String role_name;
    private String role_bilgi;
    
    private List<User> user_entity;

    public UserRole() {
    }

    public UserRole(Long role_id, String role_name, String role_bilgi) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_bilgi = role_bilgi;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }


    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_bilgi() {
        return role_bilgi;
    }

    public void setRole_bilgi(String role_bilgi) {
        this.role_bilgi = role_bilgi;
    }

    public List<User> getUser_entity() {
        return user_entity;
    }

    public void setUser_entity(List<User> user_entity) {
        this.user_entity = user_entity;
    }
    
    

    @Override
    public String toString() {
        return "UserRole{" + "role_id=" + role_id + ", role_name=" + role_name + ", role_bilgi=" + role_bilgi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.role_id);
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
        final UserRole other = (UserRole) obj;
        if (!Objects.equals(this.role_id, other.role_id)) {
            return false;
        }
        return true;
    }
    
    
    
}
