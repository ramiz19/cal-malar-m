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
    @NamedQuery(name = "Yem.findAll", query = "SELECT y FROM Yem y")
    , @NamedQuery(name = "Yem.findById", query = "SELECT y FROM Yem y WHERE y.id = :id")
    , @NamedQuery(name = "Yem.findByYemKategori", query = "SELECT y FROM Yem y WHERE y.yemKategori = :yemKategori")
    , @NamedQuery(name = "Yem.findByYemFiyat", query = "SELECT y FROM Yem y WHERE y.yemFiyat = :yemFiyat")
    , @NamedQuery(name = "Yem.findByYemAdet", query = "SELECT y FROM Yem y WHERE y.yemAdet = :yemAdet")
    , @NamedQuery(name = "Yem.findByYemMiktar", query = "SELECT y FROM Yem y WHERE y.yemMiktar = :yemMiktar")
    , @NamedQuery(name = "Yem.findByGelmeTarihi", query = "SELECT y FROM Yem y WHERE y.gelmeTarihi = :gelmeTarihi")})
public class Yem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "yem_kategori", nullable = false, length = 50)
    private String yemKategori;
    @Basic(optional = false)
    @Column(name = "yem_fiyat", nullable = false, length = 50)
    private String yemFiyat;
    @Basic(optional = false)
    @Column(name = "yem_adet", nullable = false, length = 50)
    private String yemAdet;
    @Basic(optional = false)
    @Column(name = "yem_miktar", nullable = false, length = 50)
    private String yemMiktar;
    @Basic(optional = false)
    @Column(name = "gelme_tarihi", nullable = false, length = 50)
    private String gelmeTarihi;

    public Yem() {
    }

    public Yem(Long id) {
        this.id = id;
    }

    public Yem(Long id, String yemKategori, String yemFiyat, String yemAdet, String yemMiktar, String gelmeTarihi) {
        this.id = id;
        this.yemKategori = yemKategori;
        this.yemFiyat = yemFiyat;
        this.yemAdet = yemAdet;
        this.yemMiktar = yemMiktar;
        this.gelmeTarihi = gelmeTarihi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYemKategori() {
        return yemKategori;
    }

    public void setYemKategori(String yemKategori) {
        this.yemKategori = yemKategori;
    }

    public String getYemFiyat() {
        return yemFiyat;
    }

    public void setYemFiyat(String yemFiyat) {
        this.yemFiyat = yemFiyat;
    }

    public String getYemAdet() {
        return yemAdet;
    }

    public void setYemAdet(String yemAdet) {
        this.yemAdet = yemAdet;
    }

    public String getYemMiktar() {
        return yemMiktar;
    }

    public void setYemMiktar(String yemMiktar) {
        this.yemMiktar = yemMiktar;
    }

    public String getGelmeTarihi() {
        return gelmeTarihi;
    }

    public void setGelmeTarihi(String gelmeTarihi) {
        this.gelmeTarihi = gelmeTarihi;
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
        if (!(object instanceof Yem)) {
            return false;
        }
        Yem other = (Yem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Yem[ id=" + id + " ]";
    }
    
}
