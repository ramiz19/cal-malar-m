/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.YetkiDao;
import entity.Yetkilendirme;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cemr_
 */
@Named(value="yetki")
@SessionScoped
public class YetkiBean implements Serializable{
    
    private Yetkilendirme yetki;
    private YetkiDao yetkiDao;
    private List<Yetkilendirme> yetkiList;
    
    @Inject
    private RoleBean roleBean;
    
    
    
   public String createForm() {

        this.yetki = new Yetkilendirme();
        return "/admin/yetkilendirme/create?faces-redirect=true";//navigasyon..
    }

    public String create() {
        this.getYetkiDao().insert(this.yetki);//dao sınıfında insert etme...
        return "/admin/yetkilendirme/list?faces-redirect=true";
    }

    public String updateForm(Yetkilendirme yetkiler) {
        this.yetki = yetkiler;
        return "/admin/yetkilendirme/update?faces-redirect=true";
    }

    public String update() {
         this.getYetkiDao().update(this.yetki);//
        return "/admin/yetkilendirme/list?faces-redirect=true";
    }

    public String delete(Yetkilendirme deleteYetki) {
        this.getYetkiDao().delete(deleteYetki);
        return "/admin/yetkilendirme/list?faces-redirect=true";
    }

    public String detailForm(Yetkilendirme yetkiDetail) {
        this.yetki = yetkiDetail;
        return "/admin/yetkilendirme/detail?faces-redirect=true";
    }

    public Yetkilendirme getYetki() {
        if(this.yetki==null)
            this.yetki=new Yetkilendirme();
        return yetki;
    }

    public void setYetki(Yetkilendirme yetki) {
        this.yetki = yetki;
    }

    public YetkiDao getYetkiDao() {
        if(this.yetkiDao==null)
            this.yetkiDao=new YetkiDao();
        return yetkiDao;
    }

    public void setYetkiDao(YetkiDao yetkiDao) {
        this.yetkiDao = yetkiDao;
    }

    public List<Yetkilendirme> getYetkiList() {
        this.yetkiList=this.getYetkiDao().findAll();
        return yetkiList;
    }

    public void setYetkiList(List<Yetkilendirme> yetkiList) {
        this.yetkiList = yetkiList;
    }

    public RoleBean getRoleBean() {
        return roleBean;
    }

    public void setRoleBean(RoleBean roleBean) {
        this.roleBean = roleBean;
    }
    
    
}
