/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.converter;

import admin.dao.KlinikDAO;
import entity.Poliklinik;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cemr_
 */
@FacesConverter(value="klinikConverter")
public class KlinikConverter implements Converter{

    private KlinikDAO klinikDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getKlinikDao().detail(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Poliklinik p=(Poliklinik) value;
        return p.getKlinik_id().toString();
    }

    public KlinikDAO getKlinikDao() {
        if(this.klinikDao==null)
            this.klinikDao=new KlinikDAO();
        return klinikDao;
    }

    public void setKlinikDao(KlinikDAO klinikDao) {
        this.klinikDao = klinikDao;
    }
    
}
