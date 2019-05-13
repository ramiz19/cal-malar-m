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
public class Muayene {
    private Long muayene_id;
    private String teshis;
    
    private Doktor doktor_entity;//1-n ilişki
    private Hasta hasta_entity;
   
    private List<Ilac>muayene_ilac; //many ilişki

    public Muayene() {
    }

    public Muayene(Long muayene_id, String teshis, Doktor doktor_entity, Hasta hasta_entity) {
        this.muayene_id = muayene_id;
        this.teshis = teshis;
        this.doktor_entity = doktor_entity;
        this.hasta_entity = hasta_entity;
    }

    public Long getMuayene_id() {
        return muayene_id;
    }

    public void setMuayene_id(Long muayene_id) {
        this.muayene_id = muayene_id;
    }

   
    public String getTeshis() {
        return teshis;
    }

    public void setTeshis(String teshis) {
        this.teshis = teshis;
    }

    public Doktor getDoktor_entity() {
        return doktor_entity;
    }

    public void setDoktor_entity(Doktor doktor_entity) {
        this.doktor_entity = doktor_entity;
    }

    public Hasta getHasta_entity() {
        return hasta_entity;
    }

    public void setHasta_entity(Hasta hasta_entity) {
        this.hasta_entity = hasta_entity;
    }

    public List<Ilac> getMuayene_ilac() {
        return muayene_ilac;
    }

    public void setMuayene_ilac(List<Ilac> muayene_ilac) {
        this.muayene_ilac = muayene_ilac;
    }

    
    @Override
    public String toString() {
        return "Muayene{" + "muayene_id=" + muayene_id + ", teshis=" + teshis + ", doktor_entity=" + doktor_entity + ", hasta_entity=" + hasta_entity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.muayene_id);
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
        final Muayene other = (Muayene) obj;
        if (!Objects.equals(this.muayene_id, other.muayene_id)) {
            return false;
        }
        return true;
    }
    
}
