/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.converter;

import admin.dao.RandevuDao;
import entity.Randevu;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cemr_
 */
@FacesConverter(value="randevuConverter")
public class randevuConverter implements Converter {

    private RandevuDao randevuDao;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getRandevuDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Randevu r=(Randevu) value;
        return r.getRandevu_id().toString();
    }

    public RandevuDao getRandevuDao() {
        if(this.randevuDao==null)
            this.randevuDao=new RandevuDao();
        return randevuDao;
    }
    
    
}
