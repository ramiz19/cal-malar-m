/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.HastaDao;
import entity.Hasta;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "hasta")
@SessionScoped
public class HastaBean implements Serializable {

    private Hasta hasta1;
    private HastaDao hastadao1;
    private ArrayList<Hasta> hastaList1;

    private int selectUser;

    @Inject
    private UserBean userBean;

    //////////////////////////////////////////////////////pagenation
    private int page = 1;
    private int listItemCount = 10;

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {

        int toplamKayit;
        toplamKayit = this.getHastadao1().kayitSay();

        if ((this.page * this.listItemCount) >= toplamKayit) {
            return false;
        } else {
            return true;
        }

        //return page < (this.getHastadao1().itemCount()/listItemCount);
    }

    public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }
    //////////////////////////////////////////////////////pagenation

    public int sayi() {//dashboard
        return this.getHastadao1().kayitSay();
    }

    public String updateForm(Hasta updatehasta) {
        this.hasta1 = updatehasta;
        return "/admin/hasta/update?faces-redirect=true";
    }

    public String update() {
        this.getHastadao1().update(this.hasta1);
        return "/admin/hasta/list?faces-redirect=true";
    }

    public String delete(Hasta deletehasta) {
        this.getHastadao1().delete(deletehasta);
        return "/admin/hasta/list?faces-redirect=true";
    }

    public String datailForm(Hasta detailhasta) {
        this.hasta1 = detailhasta;
        return "/admin/hasta/detail?faces-redirect=true";
    }

    public String createForm() {
        this.hasta1 = new Hasta();
        return "/admin/hasta/create?faces-redirect=true";
    }

    public String create() {
        this.getHastadao1().insert(this.hasta1, selectUser);
        return "/admin/hasta/list?faces-redirect=true";
    }

    public Hasta getHasta1() {
        if (this.hasta1 == null) {
            this.hasta1 = new Hasta();
        }
        return hasta1;
    }

    public void setHasta1(Hasta hasta1) {
        this.hasta1 = hasta1;
    }

    public HastaDao getHastadao1() {
        if (this.hastadao1 == null) {
            this.hastadao1 = new HastaDao();
        }
        return hastadao1;
    }

    public void setHastadao1(HastaDao hastadao1) {
        this.hastadao1 = hastadao1;
    }

    public ArrayList<Hasta> getHastaList1() {

        this.hastaList1 = this.getHastadao1().findAll(page, listItemCount);

        return hastaList1;
    }

    public void setHastaList1(ArrayList<Hasta> hastaList1) {
        this.hastaList1 = hastaList1;

    }

    public int getSelectUser() {
        return selectUser;
    }

    public void setSelectUser(int selectUser) {
        this.selectUser = selectUser;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
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
