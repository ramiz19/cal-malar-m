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
public class Hasta {

    private Long hasta_id;
    private String hasta_name;
    private String hasta_lastname;
    private Long hasta_yas;
    private String phone;

    private User user_entity;
    private List<Randevu> randevu_entity;
    private List<Muayene> muayene_entity;

    public Hasta() {
    }

    public Hasta(Long hasta_id, String hasta_name, String hasta_lastname, Long hasta_yas, User user_entity, String phone) {
        this.hasta_id = hasta_id;
        this.hasta_name = hasta_name;
        this.hasta_lastname = hasta_lastname;
        this.hasta_yas = hasta_yas;
        this.user_entity = user_entity;
        this.phone = phone;
    }

    public Long getHasta_id() {
        return hasta_id;
    }

    public void setHasta_id(Long hasta_id) {
        this.hasta_id = hasta_id;
    }

    public String getHasta_name() {
        return hasta_name;
    }

    public void setHasta_name(String hasta_name) {
        this.hasta_name = hasta_name;
    }

    public String getHasta_lastname() {
        return hasta_lastname;
    }

    public void setHasta_lastname(String hasta_lastname) {
        this.hasta_lastname = hasta_lastname;
    }

    public Long getHasta_yas() {
        return hasta_yas;
    }

    public void setHasta_yas(Long hasta_yas) {
        this.hasta_yas = hasta_yas;
    }

    public User getUser_entity() {
        return user_entity;
    }

    public void setUser_entity(User user_entity) {
        this.user_entity = user_entity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Randevu> getRandevu_entity() {
        return randevu_entity;
    }

    public void setRandevu_entity(List<Randevu> randevu_entity) {
        this.randevu_entity = randevu_entity;
    }

    public List<Muayene> getMuayene_entity() {
        return muayene_entity;
    }

    public void setMuayene_entity(List<Muayene> muayene_entity) {
        this.muayene_entity = muayene_entity;
    }

    @Override
    public String toString() {
        return hasta_name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.hasta_id);
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
        final Hasta other = (Hasta) obj;
        if (!Objects.equals(this.hasta_id, other.hasta_id)) {
            return false;
        }
        return true;
    }

}
