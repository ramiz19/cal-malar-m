/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.KlinikDAO;
import entity.Poliklinik;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "klinikbean")
@SessionScoped
public class KlinikBean implements Serializable {

    private List<Poliklinik> klinikList1;
    private KlinikDAO klinikdao;
    private Poliklinik klinik;

    @Inject
    private DoktorBean doktorBean;

    //////////////////////////////////////////////////////pagenation
    private int page = 1;
    private int listItemCount = 10;

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        return page < (this.getKlinikdao().itemCount() / listItemCount);
    }

    public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }
    //////////////////////////////////////////////////////pagenation

    public DoktorBean getDoktorBean() {
        return doktorBean;
    }

    public void setDoktorBean(DoktorBean doktorBean) {
        this.doktorBean = doktorBean;
    }

    public int sayi() {
        return this.getKlinikdao().kayitSay();
    }

    public String updateForm(Poliklinik klinikupdate) {
        this.klinik = klinikupdate;
        return "/admin/klinik/update?faces-redirect=true";
    }

    public String update() {
        this.getKlinikdao().update(this.klinik);
        return "/admin/klinik/list?faces-redirect=true";

    }

    public String createForm() {
        this.klinik = new Poliklinik();
        return "/admin/klinik/create?faces-redirect=true";
    }

    public String delete(Poliklinik klinikdelete) {
        this.getKlinikdao().delete(klinikdelete);
        return "/admin/klinik/list?faces-redirect=true";

    }

    public String create() {
        this.getKlinikdao().insert(this.klinik);
        return "/admin/klinik/list?faces-redirect=true";
    }

    public String detailForm(Poliklinik pol) {
        this.klinik = pol;

        return "/admin/klinik/detail?faces-redirect=true";
    }

    public Poliklinik getKlinik() {
        if (this.klinik == null) {
            this.klinik = new Poliklinik();
        }
        return klinik;
    }

    public void setKlinik(Poliklinik klinik) {
        this.klinik = klinik;
    }

    public List<Poliklinik> getKlinikList1() {
        this.klinikList1 = this.getKlinikdao().findALL();
        return klinikList1;
    }

    public void setKlinikList1(List<Poliklinik> klinikList1) {
        this.klinikList1 = klinikList1;
    }

    public KlinikDAO getKlinikdao() {
        if (this.klinikdao == null) {
            this.klinikdao = new KlinikDAO();
        }
        return klinikdao;
    }

    public void setKlinikdao(KlinikDAO klinikdao) {
        this.klinikdao = klinikdao;
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
