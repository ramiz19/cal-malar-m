/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Alaa SHATTI
 */
@Entity(name = "vehicle")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "plaque", unique = true, nullable = false)
    private String plaque;

    // @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "vehicle")
    @OneToOne(mappedBy = "vehicle")
    private DailyLog dailyLogs;

    //@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "vehicle")
    @OneToOne(mappedBy = "vehicle")
    private VehicleMaintenance vehicleMaintenance;


    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vMain_id", foreignKey = @ForeignKey(foreignKeyDefinition = "VehicleMaintenance_fk"))
    private VehicleMaintenance vehicleMaintenance;*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public DailyLog getDailyLogs() {
        return dailyLogs;
    }

    public void setDailyLogs(DailyLog dailyLogs) {
        this.dailyLogs = dailyLogs;
    }

    public VehicleMaintenance getVehicleMaintenance() {
        return vehicleMaintenance;
    }

    public void setVehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
        this.vehicleMaintenance = vehicleMaintenance;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dVeterinerlik.entity.Vehicle[ id=" + id + " ]";
    }

}
