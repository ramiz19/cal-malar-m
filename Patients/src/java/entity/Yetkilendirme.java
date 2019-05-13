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
public class Yetkilendirme {
    private Long Id;
    private UserRole role;
    private String module;
    private boolean C;
    private boolean  R;
    private boolean  U;
    private boolean  D;
    private boolean  Del;

    public Yetkilendirme() {
    }

    public Yetkilendirme(Long Id, UserRole role, String module, boolean C, boolean R, boolean U, boolean D, boolean Del) {
        this.Id = Id;
        this.role = role;
        this.module = module;
        this.C = C;
        this.R = R;
        this.U = U;
        this.D = D;
        this.Del = Del;
    }

   

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

   

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public boolean isC() {
        return C;
    }

    public void setC(boolean C) {
        this.C = C;
    }

    public boolean isR() {
        return R;
    }

    public void setR(boolean R) {
        this.R = R;
    }

    public boolean isU() {
        return U;
    }

    public void setU(boolean U) {
        this.U = U;
    }

    public boolean isD() {
        return D;
    }

    public void setD(boolean D) {
        this.D = D;
    }

    public boolean isDel() {
        return Del;
    }

    public void setDel(boolean Del) {
        this.Del = Del;
    }

   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.Id);
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
        final Yetkilendirme other = (Yetkilendirme) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
    
}
