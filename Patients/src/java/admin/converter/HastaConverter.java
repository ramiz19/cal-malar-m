/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.converter;

import admin.dao.HastaDao;
import entity.Hasta;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cemr_
 */
@FacesConverter(value="hastaConverter")
public class HastaConverter implements Converter {

    private HastaDao hastaDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getHastaDao().detail(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Hasta h=(Hasta) value;
        return h.getHasta_id().toString();
    }

    public HastaDao getHastaDao() {
        if(this.hastaDao==null)
            this.hastaDao=new HastaDao();
        return hastaDao;
    }

    public void setHastaDao(HastaDao hastaDao) {
        this.hastaDao = hastaDao;
    }
    
}
