/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cemr_
 */
@Entity
@Table(catalog = "yem_firma", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Balik.findAll", query = "SELECT b FROM Balik b")
    , @NamedQuery(name = "Balik.findById", query = "SELECT b FROM Balik b WHERE b.id = :id")
    , @NamedQuery(name = "Balik.findByBalikCinsi", query = "SELECT b FROM Balik b WHERE b.balikCinsi = :balikCinsi")
    , @NamedQuery(name = "Balik.findByBalikFiyat", query = "SELECT b FROM Balik b WHERE b.balikFiyat = :balikFiyat")
    , @NamedQuery(name = "Balik.findByKilo", query = "SELECT b FROM Balik b WHERE b.kilo = :kilo")
    , @NamedQuery(name = "Balik.findByBoy", query = "SELECT b FROM Balik b WHERE b.boy = :boy")
    , @NamedQuery(name = "Balik.findByYemKategori", query = "SELECT b FROM Balik b WHERE b.yemKategori = :yemKategori")
    , @NamedQuery(name = "Balik.findByYemKilo", query = "SELECT b FROM Balik b WHERE b.yemKilo = :yemKilo")
    , @NamedQuery(name = "Balik.findByGetirilisTarihi", query = "SELECT b FROM Balik b WHERE b.getirilisTarihi = :getirilisTarihi")})
public class Balik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "balik_cinsi", nullable = false, length = 50)
    private String balikCinsi;
    @Basic(optional = false)
    @Column(name = "balik_fiyat", nullable = false, length = 50)
    private String balikFiyat;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String kilo;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String boy;
    @Basic(optional = false)
    @Column(name = "yem_kategori", nullable = false, length = 50)
    private String yemKategori;
    @Basic(optional = false)
    @Column(name = "yem_kilo", nullable = false, length = 50)
    private String yemKilo;
    @Basic(optional = false)
    @Column(name = "getirilis_tarihi", nullable = false, length = 50)
    private String getirilisTarihi;

    public Balik() {
    }

    public Balik(Long id) {
        this.id = id;
    }

    public Balik(Long id, String balikCinsi, String balikFiyat, String kilo, String boy, String yemKategori, String yemKilo, String getirilisTarihi) {
        this.id = id;
        this.balikCinsi = balikCinsi;
        this.balikFiyat = balikFiyat;
        this.kilo = kilo;
        this.boy = boy;
        this.yemKategori = yemKategori;
        this.yemKilo = yemKilo;
        this.getirilisTarihi = getirilisTarihi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBalikCinsi() {
        return balikCinsi;
    }

    public void setBalikCinsi(String balikCinsi) {
        this.balikCinsi = balikCinsi;
    }

    public String getBalikFiyat() {
        return balikFiyat;
    }

    public void setBalikFiyat(String balikFiyat) {
        this.balikFiyat = balikFiyat;
    }

    public String getKilo() {
        return kilo;
    }

    public void setKilo(String kilo) {
        this.kilo = kilo;
    }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }

    public String getYemKategori() {
        return yemKategori;
    }

    public void setYemKategori(String yemKategori) {
        this.yemKategori = yemKategori;
    }

    public String getYemKilo() {
        return yemKilo;
    }

    public void setYemKilo(String yemKilo) {
        this.yemKilo = yemKilo;
    }

    public String getGetirilisTarihi() {
        return getirilisTarihi;
    }

    public void setGetirilisTarihi(String getirilisTarihi) {
        this.getirilisTarihi = getirilisTarihi;
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
        if (!(object instanceof Balik)) {
            return false;
        }
        Balik other = (Balik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Balik[ id=" + id + " ]";
    }
    
}
