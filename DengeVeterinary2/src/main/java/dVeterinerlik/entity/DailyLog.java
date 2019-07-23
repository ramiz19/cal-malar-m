/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alaa SHATTI
 */
@Entity
public class DailyLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String place;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateWorked;

    //@ManyToOne(fetch = FetchType.LAZY)
    //private Veterinarian veterinarian;
    //@ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.LAZY)
    /**
     * ************************************
     *
     * Relationship
     */
    @OneToOne
    private Veterinary veterinary;

    @OneToOne
    private Driver driver;

    @OneToOne
    private Vehicle vehicle;

    //@OneToMany(mappedBy = "dailyLog")
    //private List<Veterinarian> veterinarians;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "dailylog_veterinarian", joinColumns = @JoinColumn(name = "dailylog_id"),
            inverseJoinColumns = @JoinColumn(name = "veterinarian_id"))
    private List<Veterinarian> veterinarians;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "dailylog_fieldman", joinColumns = @JoinColumn(name = "dailylog_id"),
            inverseJoinColumns = @JoinColumn(name = "fieldman_id"))
    private List<Fieldman> fieldmans;

    //@ManyToOne(fetch = FetchType.LAZY)
    // private Veterinarian veterinarian;
    //@ManyToOne(fetch = FetchType.LAZY)
    //private Fieldman fieldman;
    /**
     * ****************************
     * @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH}, fetch =
     * FetchType.EAGER)
     * @JoinTable(name = "user_team", joinColumns = @JoinColumn(name =
     * "user_id"), inverseJoinColumns = @JoinColumn(name = "team_id")) private
     * List<> teams;
     * @return
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDateWorked() {
        return dateWorked;
    }

    public void setDateWorked(Date dateWorked) {
        this.dateWorked = dateWorked;
    }

    public Veterinary getVeterinary() {
        return veterinary;
    }

    public void setVeterinary(Veterinary veterinary) {
        this.veterinary = veterinary;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Fieldman> getFieldmans() {
        return fieldmans;
    }

    public void setFieldmans(List<Fieldman> fieldmans) {
        this.fieldmans = fieldmans;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public List<Veterinarian> getVeterinarians() {
        return veterinarians;
    }

    public void setVeterinarians(List<Veterinarian> veterinarians) {
        this.veterinarians = veterinarians;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DailyLog)) {
            return false;
        }
        DailyLog other = (DailyLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dVeterinerlik.entity.DailyLog[ id=" + id + " ]";
    }

}
