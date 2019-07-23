/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.DailyLogFacadeImplLocal;
import dVeterinerlik.entity.DailyLog;
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
public class DailyLogController implements Serializable {

    @EJB
    private DailyLogFacadeImplLocal dailyLogDAO;

    private DailyLog dailyLog;

    private List<DailyLog> dailyLogList;

    public void clearForm() {
        this.dailyLog = new DailyLog();
    }

    public String back() {
        this.clearForm();
        return "/admin/dailylog/list?faces-redirect=true ";
    }

    public String createForm() {
        this.dailyLog = new DailyLog();
        return "/admin/dailylog/create?faces-redirect=true ";
    }

    public String updateForm(DailyLog dailyLog) {
        this.dailyLog = dailyLog;
        return "/admin/dailylog/update?faces-redirect=true ";
    }

    public String update() {
        dailyLogDAO.edit(this.dailyLog);
        this.dailyLog = new DailyLog();
        return "/admin/dailylog/list?faces-redirect=true ";
    }

    public void deleteConfirm(DailyLog dailyLog) {
        this.dailyLog = dailyLog;
    }

    public String delete(DailyLog dailyLog) {
        dailyLogDAO.remove(dailyLog);
        this.clearForm();
        return "/admin/dailylog/list?faces-redirect=true ";
    }

    public String create() {
        dailyLogDAO.create(this.dailyLog);
        this.dailyLog = new DailyLog();
        return "/admin/dailylog/list?faces-redirect=true ";
    }

    public DailyLog getDailyLog() {
        if (this.dailyLog == null) {
            this.dailyLog = new DailyLog();
        }
        return dailyLog;
    }

    public void setDailyLog(DailyLog dailyLog) {
        this.dailyLog = dailyLog;
    }

    public List<DailyLog> getDailyLogList() {
        this.dailyLogList = this.dailyLogDAO.findAll();
        return dailyLogList;
    }

    public void setDailyLogList(List<DailyLog> dailyLogList) {
        this.dailyLogList = dailyLogList;
    }

}
