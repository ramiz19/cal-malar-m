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
public class Doktor {
    private Long doktor_id;//converter yapabilmek için Long yaptık....
    private String doktor_name;
    private String doktor_lastname;
    
    private User user_entity;//1 doktorun 1 user e vardır....
    private Poliklinik klinik_entity;//1 doktorun bir kliniği vardır...
    
    
    private List<Muayene>muayene_entity;

    public Doktor() {
    }

    public Doktor(Long doktor_id, String doktor_name, String doktor_lastname, User user_entity, Poliklinik klinik_entity) {
        this.doktor_id = doktor_id;
        this.doktor_name = doktor_name;
        this.doktor_lastname = doktor_lastname;
        this.user_entity = user_entity;
        this.klinik_entity = klinik_entity;
    }

    public Long getDoktor_id() {
        return doktor_id;
    }

    public void setDoktor_id(Long doktor_id) {
        this.doktor_id = doktor_id;
    }

    public String getDoktor_name() {
        return doktor_name;
    }

    public void setDoktor_name(String doktor_name) {
        this.doktor_name = doktor_name;
    }

    public String getDoktor_lastname() {
        return doktor_lastname;
    }

    public void setDoktor_lastname(String doktor_lastname) {
        this.doktor_lastname = doktor_lastname;
    }

    public User getUser_entity() {
        return user_entity;
    }

    public void setUser_entity(User user_entity) {
        this.user_entity = user_entity;
    }

    public Poliklinik getKlinik_entity() {
        return klinik_entity;
    }

    public void setKlinik_entity(Poliklinik klinik_entity) {
        this.klinik_entity = klinik_entity;
    }

    public List<Muayene> getMuayene_entity() {
        return muayene_entity;
    }

    public void setMuayene_entity(List<Muayene> muayene_entity) {
        this.muayene_entity = muayene_entity;
    }
    
    
    
///equals ve hashcode metodlarını converter için olusturduk.....
    @Override
    public String toString() {
        return  doktor_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.doktor_id);
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
        final Doktor other = (Doktor) obj;
        if (!Objects.equals(this.doktor_id, other.doktor_id)) {
            return false;
        }
        return true;
    }
    
}
