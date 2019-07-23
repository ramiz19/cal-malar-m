/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.RevenueFacadeImplLocal;
import dVeterinerlik.entity.Revenue;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Alaa SHATTI
 */
@Named
@SessionScoped
public class RevenueController implements Serializable {

    @EJB
    private RevenueFacadeImplLocal revenueDAO;

    private Revenue revenue;

    private List<Revenue> revenueList;

    public void clearForm() {
        this.revenue = new Revenue();
    }

    public String back() {
        this.clearForm();
        return "/admin/revenue/list?faces-redirect=true";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/revenue/create?faces-redirect=true";
    }

    public String create() {
        revenueDAO.create(this.revenue);
        this.clearForm();
        return "/admin/revenue/list?faces-redirect=true";
    }

    public String updateForm(Revenue revenue) {
        this.revenue = revenue;
        return "/admin/revenue/update?faces-redirect=true";
    }

    public String update() {
        revenueDAO.edit(this.revenue);
        this.clearForm();
        return "/admin/revenue/list?faces-redirect=true";
    }

    public void deleteConfirm(Revenue revenue) {
        this.revenue = revenue;
        // return "admin/expense/list?faces-redirect=true";
    }

    public String delete(Revenue revenue) {
        revenueDAO.remove(revenue);
        this.clearForm();
        return "/admin/revenue/list?faces-redirect=true";
    }

    public Revenue getRevenue() {
        if (this.revenue == null) {
            this.revenue = new Revenue();
        }
        return revenue;
    }

    public void setRevenue(Revenue revenue) {
        this.revenue = revenue;
    }

    public List<Revenue> getRevenueList() {
        this.revenueList = this.revenueDAO.findAll();
        return revenueList;
    }

    public void setRevenueList(List<Revenue> revenueList) {
        this.revenueList = revenueList;
    }

}
