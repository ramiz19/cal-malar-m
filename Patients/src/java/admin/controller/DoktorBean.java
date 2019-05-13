/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.DoktorDao;
import entity.Doktor;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */

@Named(value = "doktor")//html le baglantı kurmayı saglayan değişken...
@SessionScoped //kullanıcı oturumu actığı an bean sınıfı olusturulur ve kullanıcı oturumu kapatana kadar bean sınıfı saklanır..
public class DoktorBean implements Serializable {

    private Doktor doktor2;
    private DoktorDao doktordao2;
    private List<Doktor> doktorList2;
   

    @Inject
    private UserBean userBean;//user nesnesi ile ilişki oluşturma....

    @Inject
    private KlinikBean klinikBean;//klinik nesnesi ile ilişki oluşturma...

    private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.getDoktordao2().kayitSay();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.getDoktordao2().kayitSay();
        
        if ((this.page*this.listItemCount) >= toplamKayit) {
            return false;
        } else {
            return true;
        }
    }

    public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }

    public String createForm() {

        this.doktor2 = new Doktor();
        return "/admin/doktor/create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getDoktordao2().insert(this.doktor2);//dao sınıfında insert etme...
        return "/admin/doktor/list?faces-redirect=true";
    }

    public String updateForm(Doktor updateDoktor) {
        this.doktor2 = updateDoktor;
        return "/admin/doktor/update?faces-redirect=true";
    }

    public String update() {
        this.getDoktordao2().update(this.doktor2);
        return "/admin/doktor/list?faces-redirect=true";
    }

    public String delete(Doktor deleteDoktor) {
        this.getDoktordao2().delete(deleteDoktor);
        return "/admin/doktor/list?faces-redirect=true";
    }

    public String detailForm(Doktor doktorDetail) {
        this.doktor2 = doktorDetail;
        return "/admin/doktor/detail?faces-redirect=true";
    }

    public Doktor getDoktor2() {
        if (this.doktor2 == null) {
            this.doktor2 = new Doktor();
        }
        return doktor2;
    }

    public void setDoktor2(Doktor doktor2) {
        this.doktor2 = doktor2;
    }

    public DoktorDao getDoktordao2() {
        if (this.doktordao2 == null) {
            this.doktordao2 = new DoktorDao();
        }
        return doktordao2;
    }

    public void setDoktordao2(DoktorDao doktordao2) {
        this.doktordao2 = doktordao2;
    }

    public List<Doktor> getDoktorList2() {
        this.doktorList2 = this.getDoktordao2().findAll(page, listItemCount);
        return doktorList2;
    }

    public void setDoktorList2(List<Doktor> doktorList2) {
        this.doktorList2 = doktorList2;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public KlinikBean getKlinikBean() {
        return klinikBean;
    }

    public void setKlinikBean(KlinikBean klinikBean) {
        this.klinikBean = klinikBean;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getListItemCount() {
        return listItemCount;
    }

    public void setListItemCount(int listItemCount) {
        this.listItemCount = listItemCount;
    }

}
