/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.RandevuDao;
import entity.Randevu;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "randevuBean")
@SessionScoped
public class RandevuBean implements Serializable {

    private Randevu randevu;
    private RandevuDao randevuDao;
    private List<Randevu> randevuList;

    @Inject
    private HastaBean hastaBean2;
    @Inject
    private KlinikBean klinikBean2;

    //////////////////////////////////////////////////////pagenation
    private int page = 1;
    private int listItemCount = 10;

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int toplamKayit;
        toplamKayit = this.getRandevuDao().kayitSay();

        if ((this.page * this.listItemCount) >= toplamKayit) {
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
    //////////////////////////////////////////////////////pagenation

    public int sayi() {
        return this.getRandevuDao().kayitSay();
    }

    public String updateForm(Randevu updateRand) {
        this.randevu = updateRand;
        return "/admin/randevu/update?faces-redirect=true";
    }

    public String update() {
        this.getRandevuDao().update(this.randevu);
        return "/admin/randevu/list?faces-redirect=true";
    }

    public String createForm() {
        this.randevu = new Randevu();
        return "/admin/randevu/create?faces-redirect=true";
    }

    public String create() {
        this.getRandevuDao().insert(this.randevu);
        return "/admin/randevu/list?faces-redirect=true";
    }

    public String delete(Randevu deleteRandevu) {
        this.getRandevuDao().delete(deleteRandevu);
        return "/admin/randevu/list?faces-redirect=true";
    }

    public String detailForm(Randevu randevuDetail) {
        this.randevu = randevuDetail;
        return "/admin/randevu/detail?faces-redirect=true";
    }

    public Randevu getRandevu() {
        if (this.randevu == null) {
            this.randevu = new Randevu();
        }
        return randevu;
    }

    public void setRandevu(Randevu randevu) {
        this.randevu = randevu;
    }

    public RandevuDao getRandevuDao() {
        if (this.randevuDao == null) {
            this.randevuDao = new RandevuDao();
        }
        return randevuDao;
    }

    public void setRandevuDao(RandevuDao randevuDao) {
        this.randevuDao = randevuDao;
    }

    public List<Randevu> getRandevuList() {
        this.randevuList = this.getRandevuDao().findAll(page, listItemCount);
        return randevuList;
    }

    public void setRandevuList(List<Randevu> randevuList) {
        this.randevuList = randevuList;
    }

    public HastaBean getHastaBean2() {
        return hastaBean2;
    }

    public void setHastaBean2(HastaBean hastaBean2) {
        this.hastaBean2 = hastaBean2;
    }

    public KlinikBean getKlinikBean2() {
        return klinikBean2;
    }

    public void setKlinikBean2(KlinikBean klinikBean2) {
        this.klinikBean2 = klinikBean2;
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
