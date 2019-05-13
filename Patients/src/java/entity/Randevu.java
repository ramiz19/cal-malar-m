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
public class Randevu {
    private Long randevu_id;
    private String sikayet;
    private String tarih;
    private String saat;
    
    private Hasta hasta_entity;
    private Poliklinik klinik_entity;

    public Randevu() {
    }

    public Randevu(Long randevu_id, String sikayet, String tarih, String saat, Hasta hasta_entity, Poliklinik klinik_entity) {
        this.randevu_id = randevu_id;
        this.sikayet = sikayet;
        this.tarih = tarih;
        this.saat = saat;
        this.hasta_entity = hasta_entity;
        this.klinik_entity = klinik_entity;
    }

  

    public Long getRandevu_id() {
        return randevu_id;
    }

    public void setRandevu_id(Long randevu_id) {
        this.randevu_id = randevu_id;
    }

    public String getSikayet() {
        return sikayet;
    }

    public void setSikayet(String sikayet) {
        this.sikayet = sikayet;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

   
    public Hasta getHasta_entity() {
        return hasta_entity;
    }

    public void setHasta_entity(Hasta hasta_entity) {
        this.hasta_entity = hasta_entity;
    }

    public Poliklinik getKlinik_entity() {
        return klinik_entity;
    }

    public void setKlinik_entity(Poliklinik klinik_entity) {
        this.klinik_entity = klinik_entity;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.randevu_id);
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
        final Randevu other = (Randevu) obj;
        if (!Objects.equals(this.randevu_id, other.randevu_id)) {
            return false;
        }
        return true;
    }
   
    
    
}
