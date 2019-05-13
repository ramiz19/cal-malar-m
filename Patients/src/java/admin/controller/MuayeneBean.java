/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.MuayeneDao;
import entity.Muayene;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value = "muayene")
@SessionScoped
public class MuayeneBean implements Serializable {

    private Muayene muayene;
    private MuayeneDao muayenedao;
    private List<Muayene> muayenelist;

    @Inject
    private IlacBean ilacbean;
    @Inject
    private HastaBean hastaBean;
    @Inject
    private DoktorBean doktorBean;

    //////////////////////////////////////////////////////pagenation
    private int page = 1;
    private int listItemCount = 10;

    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        return page < (this.getMuayenedao().itemCount() / listItemCount);
    }

    public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }
    //////////////////////////////////////////////////////pagenation

    public int sayi() {
        return this.getMuayenedao().kayitSay();
    }

    public String createForm() {
        this.muayene = new Muayene();
        return "/admin/muayene/create?faces-redirect=true";
    }

    public String create() {
        this.getMuayenedao().insert(this.muayene);
        // this.getMuayenedao().insert(this.muayene,selectedDoktor,selectedHasta,selected_ilac);
        return "/admin/muayene/list?faces-redirect=true";

    }

    public String detailForm(Muayene muayeneDetail) {
        this.muayene = muayeneDetail;
        return "/admin/muayene/detail?faces-redirect=true";
    }

    public String updateForm(Muayene m) {
        this.muayene = m;
        return "/admin/muayene/update?faces-redirect=true";
    }

    public String update() {
        this.getMuayenedao().update(this.muayene);
        return "/admin/muayene/list?faces-redirect=true";
    }

    public String delete(Muayene muayene) {
        this.getMuayenedao().delete(muayene);

        return "/admin/muayene/list?faces-redirect=true";
    }

    public Muayene getMuayene() {
        if (this.muayene == null) {
            this.muayene = new Muayene();
        }
        return muayene;
    }

    public void setMuayene(Muayene muayene) {
        this.muayene = muayene;
    }

    public MuayeneDao getMuayenedao() {
        if (this.muayenedao == null) {
            this.muayenedao = new MuayeneDao();
        }
        return muayenedao;
    }

    public void setMuayenedao(MuayeneDao muayenedao) {
        this.muayenedao = muayenedao;
    }

    public List<Muayene> getMuayenelist() {
        this.muayenelist = this.getMuayenedao().findAll(page, listItemCount);
        return muayenelist;
    }

    public void setMuayenelist(List<Muayene> muayenelist) {
        this.muayenelist = muayenelist;
    }

    public HastaBean getHastaBean() {
        return hastaBean;
    }

    public void setHastaBean(HastaBean hastaBean) {
        this.hastaBean = hastaBean;
    }

    public DoktorBean getDoktorBean() {
        return doktorBean;
    }

    public void setDoktorBean(DoktorBean doktorBean) {
        this.doktorBean = doktorBean;
    }

    public IlacBean getIlacbean() {
        return ilacbean;
    }

    public void setIlacbean(IlacBean ilacbean) {
        this.ilacbean = ilacbean;
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
