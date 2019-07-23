/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.ExpenseFacadeImplLocal;
import dVeterinerlik.entity.Expense;
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
public class ExpenseController implements Serializable {

    @EJB

    private ExpenseFacadeImplLocal expenseDAO;

    private Expense expense;

    private List<Expense> expenseList;

    public void clearForm() {
        this.expense = new Expense();
    }
    public String back(){
        this.clearForm();
        return "/admin/expense/list?faces-redirect=true";
    }

    public String createForm() {
        this.clearForm();
        return "/admin/expense/create?faces-redirect=true";
    }

    public String create() {
        expenseDAO.create(this.expense);
        this.clearForm();
        return "/admin/expense/list?faces-redirect=true";
    }

    public String updateForm(Expense expense) {
        this.expense = expense;
        return "/admin/expense/update?faces-redirect=true";
    }

    public String update() {
        expenseDAO.edit(this.expense);
        this.clearForm();
        return "/admin/expense/list?faces-redirect=true";
    }
    
    public void deleteConfirm(Expense expense){
        this.expense = expense ;
       // return "admin/expense/list?faces-redirect=true";
    }
    public String delete (Expense expense){
        expenseDAO.remove(expense);
        this.clearForm();
        return "/admin/expense/list?faces-redirect=true";
    }

    public Expense getExpense() {
        if (this.expense == null) {
            this.expense = new Expense();
        }
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public List<Expense> getExpenseList() {
        this.expenseList = this.expenseDAO.findAll();
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

}
