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
public class Ilac {

    private Long ilac_id;
    private String ilac_name;
    private String ilac_bilgi;
    
    private List<Muayene> ilac_muayene;//ilacla muayenenin list olmasının sebebi birden fazla nesne aldığı için...

    public Ilac() {
    }

    public Ilac(Long ilac_id, String ilac_name, String ilac_bilgi) {
        this.ilac_id = ilac_id;
        this.ilac_name = ilac_name;
        this.ilac_bilgi = ilac_bilgi;
    }

    public Long getIlac_id() {
        return ilac_id;
    }

    public void setIlac_id(Long ilac_id) {
        this.ilac_id = ilac_id;
    }

  
    public String getIlac_name() {
        return ilac_name;
    }

    public void setIlac_name(String ilac_name) {
        this.ilac_name = ilac_name;
    }

    public String getIlac_bilgi() {
        return ilac_bilgi;
    }

    public void setIlac_bilgi(String ilac_bilgi) {
        this.ilac_bilgi = ilac_bilgi;
    }

    public List<Muayene> getIlac_muayene() {
        return ilac_muayene;
    }

    public void setIlac_muayene(List<Muayene> ilac_muayene) {
        this.ilac_muayene = ilac_muayene;
    }
    
    

    @Override
    public String toString() {
        return  ilac_name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.ilac_id);
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
        final Ilac other = (Ilac) obj;
        if (!Objects.equals(this.ilac_id, other.ilac_id)) {
            return false;
        }
        return true;
    }
    
    

}
