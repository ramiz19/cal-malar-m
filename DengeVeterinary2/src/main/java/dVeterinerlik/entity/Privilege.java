/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alaa SHATTI
 */
@Entity
public class Privilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean C;
    private boolean R;
    private boolean U;
    private boolean D;

    private String module;

    @ManyToOne(fetch = FetchType.LAZY)
    private Groups groups;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "all_entity_id")
    /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "privilege_entity", joinColumns = @JoinColumn(name = "privilege_id"),
            inverseJoinColumns = @JoinColumn(name = "entity_id"))
    private List<AllEntity> allEntitys;*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dVeterinerlik.entity.Privileges[ id=" + id + " ]";
    }

}
