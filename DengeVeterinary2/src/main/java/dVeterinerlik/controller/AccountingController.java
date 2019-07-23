/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.AccountingFacadeImplLocal;
import dVeterinerlik.entity.Accounting;
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
public class AccountingController implements Serializable {

    @EJB
    private AccountingFacadeImplLocal accountingDAO;

    private Accounting accounting;
    
     private int page = 1;
    private int listItemCount = 10;

    
    public int sayi(){
    return this.accountingDAO.count();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        
        int toplamKayit;        
        toplamKayit = this.accountingDAO.count();
        
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

    private List<Accounting> accountingList;

    public void clearForm() {
        this.accounting = new Accounting();
    }

    public String back() {
        this.clearForm();
        return "/admin/accounting/list?faces-redirect=true ";
    }

    public String createForm() {
        this.accounting = new Accounting();
        return "/admin/accounting/create?faces-redirect=true ";
    }

    public String updateForm(Accounting accounting) {
        this.accounting = accounting;
        return "/admin/accounting/update?faces-redirect=true ";
    }

    public String update() {
        accountingDAO.edit(this.accounting);
        this.accounting = new Accounting();
        return "/admin/accounting/list?faces-redirect=true ";
    }

    public void deleteConfirm(Accounting accounting) {
        this.accounting = accounting;
    }

    public String delete(Accounting accounting) {
        accountingDAO.remove(accounting);
        this.clearForm();
        return "/admin/accounting/list?faces-redirect=true ";
    }

    public String create() {
        accountingDAO.create(this.accounting);
        this.accounting = new Accounting();
        return "/admin/accounting/list?faces-redirect=true ";
    }

    public Accounting getAccounting() {
        if (this.accounting == null) {
            this.accounting = new Accounting();
        }
        return accounting;
    }

    public void setAccounting(Accounting accounting) {
        this.accounting = accounting;

    }

    public List<Accounting> getAccountingList() {
        this.accountingList = this.accountingDAO.findAll();
        return accountingList;
    }

    public void setAccountingList(List<Accounting> accountingList) {
        this.accountingList = accountingList;
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
