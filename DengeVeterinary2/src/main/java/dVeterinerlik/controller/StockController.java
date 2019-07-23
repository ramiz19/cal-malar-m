/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.StockFacadeImplLocal;
import dVeterinerlik.entity.Stock;
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
public class StockController implements Serializable {

    @EJB
    private StockFacadeImplLocal stockDAO;

    private Stock stock;

    private List<Stock> stockList;

    public void clearForm() {
        this.stock = new Stock();
    }

    public String back() {
        this.clearForm();
        return "/admin/stock/list?faces-redirect=true ";
    }

    public String createForm() {
        this.stock = new Stock();
        return "/admin/stock/create?faces-redirect=true ";
    }

    public String updateForm(Stock stock) {
        this.stock = stock;
        return "/admin/stock/update?faces-redirect=true ";
    }

    public String update() {
        stockDAO.edit(this.stock);
        this.stock = new Stock();
        return "/admin/stock/list?faces-redirect=true ";
    }

    public void deleteConfirm(Stock stock) {
        this.stock = stock;
    }

    public String delete(Stock stock) {
        stockDAO.remove(stock);
        this.clearForm();
        return "/admin/stock/list?faces-redirect=true ";
    }

    public String create() {
        stockDAO.create(this.stock);
        this.stock = new Stock();
        return "/admin/stock/list?faces-redirect=true ";
    }

    public Stock getStock() {
        if (this.stock == null) {
            this.stock = new Stock();
        }
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public List<Stock> getStockList() {
        this.stockList = this.stockDAO.findAll();
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

}
