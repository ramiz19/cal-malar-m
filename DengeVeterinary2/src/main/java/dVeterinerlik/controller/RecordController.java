/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.controller;

import dVeterinerlik.dao.interfaces.RecordFacadeImplLocal;
import dVeterinerlik.entity.Record;
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
public class RecordController implements Serializable {

    @EJB

    private RecordFacadeImplLocal recordDAO;

    private Record record;

    private List<Record> recordList;
    
    public void clearForm() {
        this.record = new Record();
    }

    public String back() {
        this.clearForm();
        return "/admin/record/list?faces-redirect=true ";
    }

    public String createForm() {
        this.record = new Record();
        return "/admin/record/create?faces-redirect=true ";
    }

    public String updateForm(Record record) {
        this.record = record;
        return "/admin/record/update?faces-redirect=true ";
    }

    public String update() {
        recordDAO.edit(this.record);
        this.record = new Record();
        return "/admin/record/list?faces-redirect=true ";
    }

    public void deleteConfirm(Record record) {
        this.record = record;
    }

    public String delete(Record record) {
        recordDAO.remove(record);
        this.clearForm();
        return "/admin/record/list?faces-redirect=true ";
    }

    public String create() {
        recordDAO.create(this.record);
        this.record = new Record();
        return "/admin/record/list?faces-redirect=true ";
    }

    public Record getRecord() {
        if (this.record == null) {
            this.record = new Record();
        }
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public List<Record> getRecordList() {
        this.recordList = this.recordDAO.findAll();
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

}
