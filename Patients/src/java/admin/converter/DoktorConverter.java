/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.converter;

import admin.dao.DoktorDao;
import entity.Doktor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cemr_
 */
@FacesConverter(value="doktorConverter")//html tarafında bir nesne secebilmemiz için gerekli olan işlem...
public class DoktorConverter implements Converter{

    private DoktorDao doktorDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getDoktorDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Doktor d=(Doktor) value;
        return d.getDoktor_id().toString();
    }

    public DoktorDao getDoktorDao() {
        if(this.doktorDao==null)
            this.doktorDao=new DoktorDao();
        return doktorDao;
    }

    public void setDoktorDao(DoktorDao doktorDao) {
        this.doktorDao = doktorDao;
    }
    
    
}
