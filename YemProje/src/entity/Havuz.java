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
    @NamedQuery(name = "Havuz.findAll", query = "SELECT h FROM Havuz h")
    , @NamedQuery(name = "Havuz.findById", query = "SELECT h FROM Havuz h WHERE h.id = :id")
    , @NamedQuery(name = "Havuz.findByHavuzNo", query = "SELECT h FROM Havuz h WHERE h.havuzNo = :havuzNo")
    , @NamedQuery(name = "Havuz.findByYemKategori", query = "SELECT h FROM Havuz h WHERE h.yemKategori = :yemKategori")
    , @NamedQuery(name = "Havuz.findByYemMiktar", query = "SELECT h FROM Havuz h WHERE h.yemMiktar = :yemMiktar")
    , @NamedQuery(name = "Havuz.findByBalikCinsi", query = "SELECT h FROM Havuz h WHERE h.balikCinsi = :balikCinsi")
    , @NamedQuery(name = "Havuz.findByHavuzdakiBalikSayisi", query = "SELECT h FROM Havuz h WHERE h.havuzdakiBalikSayisi = :havuzdakiBalikSayisi")
    , @NamedQuery(name = "Havuz.findByAryatorSayisi", query = "SELECT h FROM Havuz h WHERE h.aryatorSayisi = :aryatorSayisi")})
public class Havuz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "havuz_no", nullable = false)
    private int havuzNo;
    @Basic(optional = false)
    @Column(name = "yem_kategori", nullable = false, length = 50)
    private String yemKategori;
    @Basic(optional = false)
    @Column(name = "yem_miktar", nullable = false, length = 50)
    private String yemMiktar;
    @Basic(optional = false)
    @Column(name = "balik_cinsi", nullable = false, length = 50)
    private String balikCinsi;
    @Basic(optional = false)
    @Column(name = "havuzdaki_balik_sayisi", nullable = false, length = 50)
    private String havuzdakiBalikSayisi;
    @Basic(optional = false)
    @Column(name = "aryator_sayisi", nullable = false)
    private String aryatorSayisi;

    public Havuz() {
    }

    public Havuz(Long id) {
        this.id = id;
    }

    public Havuz(Long id, int havuzNo, String yemKategori, String yemMiktar, String balikCinsi, String havuzdakiBalikSayisi, String aryatorSayisi) {
        this.id = id;
        this.havuzNo = havuzNo;
        this.yemKategori = yemKategori;
        this.yemMiktar = yemMiktar;
        this.balikCinsi = balikCinsi;
        this.havuzdakiBalikSayisi = havuzdakiBalikSayisi;
        this.aryatorSayisi = aryatorSayisi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHavuzNo() {
        return havuzNo;
    }

    public void setHavuzNo(int havuzNo) {
        this.havuzNo = havuzNo;
    }

    public String getYemKategori() {
        return yemKategori;
    }

    public void setYemKategori(String yemKategori) {
        this.yemKategori = yemKategori;
    }

    public String getYemMiktar() {
        return yemMiktar;
    }

    public void setYemMiktar(String yemMiktar) {
        this.yemMiktar = yemMiktar;
    }

    public String getBalikCinsi() {
        return balikCinsi;
    }

    public void setBalikCinsi(String balikCinsi) {
        this.balikCinsi = balikCinsi;
    }

    public String getHavuzdakiBalikSayisi() {
        return havuzdakiBalikSayisi;
    }

    public void setHavuzdakiBalikSayisi(String havuzdakiBalikSayisi) {
        this.havuzdakiBalikSayisi = havuzdakiBalikSayisi;
    }

    public String getAryatorSayisi() {
        return aryatorSayisi;
    }

    public void setAryatorSayisi(String aryatorSayisi) {
        this.aryatorSayisi = aryatorSayisi;
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
        if (!(object instanceof Havuz)) {
            return false;
        }
        Havuz other = (Havuz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Havuz[ id=" + id + " ]";
    }
    
}
