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
    @NamedQuery(name = "Depo.findAll", query = "SELECT d FROM Depo d")
    , @NamedQuery(name = "Depo.findById", query = "SELECT d FROM Depo d WHERE d.id = :id")
    , @NamedQuery(name = "Depo.findByYemFirma", query = "SELECT d FROM Depo d WHERE d.yemFirma = :yemFirma")
    , @NamedQuery(name = "Depo.findByYemKategori", query = "SELECT d FROM Depo d WHERE d.yemKategori = :yemKategori")
    , @NamedQuery(name = "Depo.findByToplamYemAdet", query = "SELECT d FROM Depo d WHERE d.toplamYemAdet = :toplamYemAdet")
    , @NamedQuery(name = "Depo.findByYemFiyat", query = "SELECT d FROM Depo d WHERE d.yemFiyat = :yemFiyat")})
public class Depo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "yem_firma", nullable = false, length = 50)
    private String yemFirma;
    @Basic(optional = false)
    @Column(name = "yem_kategori", nullable = false, length = 50)
    private String yemKategori;
    @Basic(optional = false)
    @Column(name = "toplam_yem_adet", nullable = false, length = 50)
    private String toplamYemAdet;
    @Basic(optional = false)
    @Column(name = "yem_fiyat", nullable = false, length = 50)
    private String yemFiyat;

    public Depo() {
    }

    public Depo(Long id) {
        this.id = id;
    }

    public Depo(Long id, String yemFirma, String yemKategori, String toplamYemAdet, String yemFiyat) {
        this.id = id;
        this.yemFirma = yemFirma;
        this.yemKategori = yemKategori;
        this.toplamYemAdet = toplamYemAdet;
        this.yemFiyat = yemFiyat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYemFirma() {
        return yemFirma;
    }

    public void setYemFirma(String yemFirma) {
        this.yemFirma = yemFirma;
    }

    public String getYemKategori() {
        return yemKategori;
    }

    public void setYemKategori(String yemKategori) {
        this.yemKategori = yemKategori;
    }

    public String getToplamYemAdet() {
        return toplamYemAdet;
    }

    public void setToplamYemAdet(String toplamYemAdet) {
        this.toplamYemAdet = toplamYemAdet;
    }

    public String getYemFiyat() {
        return yemFiyat;
    }

    public void setYemFiyat(String yemFiyat) {
        this.yemFiyat = yemFiyat;
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
        if (!(object instanceof Depo)) {
            return false;
        }
        Depo other = (Depo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Depo[ id=" + id + " ]";
    }
    
}
