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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alaa SHATTI
 */
@Entity(name = "fieldman")
public class Fieldman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tc", unique = true, nullable = false)
    private Long tc;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String Surname;

    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private Long phoneNum;

    @Column(name = "start_up_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startUpDate;

    @Column(name = "salary", nullable = false)
    private double salary;

    //@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "fieldman")
    //private List<DailyLog> dailyLogs;
    //private DailyLog dailyLog;
    //@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "fieldman")
    // private List<DailyLog> dailyLogs;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTc() {
        return tc;
    }

    public void setTc(Long tc) {
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getStartUpDate() {
        return startUpDate;
    }

    public void setStartUpDate(Date startUpDate) {
        this.startUpDate = startUpDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
        if (!(object instanceof Fieldman)) {
            return false;
        }
        Fieldman other = (Fieldman) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dVeterinerlik.entity.Fieldman[ id=" + id + " ]";
    }

}
