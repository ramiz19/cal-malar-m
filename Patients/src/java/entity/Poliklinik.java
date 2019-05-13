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
public class Poliklinik {
    
    private Long klinik_id;
    private String klinik_name;
    private String klinik_bilgi;
  
    private List<Randevu>randevu_entity;
    private List<Doktor>doktor_entity;//bir klinikte bir cok doktor olabilir....n tane secim yapmak için...

    public Poliklinik() {
        
        
    }

    public Poliklinik(Long klinik_id, String klinik_name, String klinik_bilgi) {
        this.klinik_id = klinik_id;
        this.klinik_name = klinik_name;
        this.klinik_bilgi = klinik_bilgi;
    }

    public Long getKlinik_id() {
        return klinik_id;
    }

    public void setKlinik_id(Long klinik_id) {
        this.klinik_id = klinik_id;
    }
    
    


    public String getKlinik_name() {
        return klinik_name;
    }

    public void setKlinik_name(String klinik_name) {
        this.klinik_name = klinik_name;
    }

    public String getKlinik_bilgi() {
        return klinik_bilgi;
    }

    public void setKlinik_bilgi(String klinik_bilgi) {
        this.klinik_bilgi = klinik_bilgi;
    }

    public List<Randevu> getRandevu_entity() {
        return randevu_entity;
    }

    public void setRandevu_entity(List<Randevu> randevu_entity) {
        this.randevu_entity = randevu_entity;
    }
    

    public List<Doktor> getDoktor_entity() {
        return doktor_entity;
    }

    public void setDoktor_entity(List<Doktor> doktor_entity) {
        this.doktor_entity = doktor_entity;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.klinik_id);
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
        final Poliklinik other = (Poliklinik) obj;
        if (!Objects.equals(this.klinik_id, other.klinik_id)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Poliklinik{" + "klinik_id=" + klinik_id + ", klinik_name=" + klinik_name + ", klinik_bilgi=" + klinik_bilgi + '}';
    }

   

    
    
}
