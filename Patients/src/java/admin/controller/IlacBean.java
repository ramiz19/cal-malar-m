/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.IlacDao;
import entity.Ilac;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "ilacbean")
@SessionScoped
public class IlacBean implements Serializable {

    private Ilac ilac2;
    private IlacDao ilacdao2;
    private List<Ilac> ilacList2;

    @Inject
    private MuayeneBean muayenebean;

    //////////////////////////////////////////////////////pagenation
    private int page = 1;
    private int listItemCount = 10;

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {

        return page < (this.getIlacdao2().itemCount() / listItemCount);
    }

    public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }
    //////////////////////////////////////////////////////pagenation

    public int sayi() {
        return this.getIlacdao2().kayitSay();
    }

    public String createForm() {
        this.ilac2 = new Ilac();
        return "/admin/ilac/create?faces-redirect=true";
    }

    public String create() {
        this.getIlacdao2().insert(this.ilac2);
        return "/admin/ilac/list?faces-redirect=true";
    }

    public String delete(Ilac ilacdelete) {
        this.getIlacdao2().delete(ilacdelete);
        return "/admin/ilac/list?faces-redirect=true";
    }

    public String updateForm(Ilac ilacupdate) {
        this.ilac2 = ilacupdate;
        return "/admin/ilac/update?faces-redirect=true";
    }

    public String update() {
        this.getIlacdao2().update(this.ilac2);
        return "/admin/ilac/list?faces-redirect=true";
    }

    public String detailForm(Ilac ilacdetail) {
        this.ilac2 = ilacdetail;
        return "/admin/ilac/detail?faces-redirect=true";
    }

    public Ilac getIlac2() {
        if (this.ilac2 == null) {
            this.ilac2 = new Ilac();
        }
        return ilac2;
    }

    public void setIlac2(Ilac ilac2) {
        this.ilac2 = ilac2;
    }

    public IlacDao getIlacdao2() {
        if (this.ilacdao2 == null) {
            this.ilacdao2 = new IlacDao();
        }
        return ilacdao2;
    }

    public void setIlacdao2(IlacDao ilacdao2) {
        this.ilacdao2 = ilacdao2;
    }

    public List<Ilac> getIlacList2() {
        this.ilacList2 = this.getIlacdao2().findAll(page, listItemCount);
        return ilacList2;
    }

    public void setIlacList2(List<Ilac> ilacList2) {
        this.ilacList2 = ilacList2;
    }

    public MuayeneBean getMuayenebean() {
        return muayenebean;
    }

    public void setMuayenebean(MuayeneBean muayenebean) {
        this.muayenebean = muayenebean;
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
