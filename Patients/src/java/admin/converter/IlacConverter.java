/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.converter;

import admin.dao.IlacDao;
import entity.Ilac;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cemr_
 */
@FacesConverter(value="ilacConverter")
public class IlacConverter implements Converter{

    private IlacDao ilacDao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getIlacDao().detail(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       Ilac i=(Ilac) value;
       return i.getIlac_id().toString();
    }

    public IlacDao getIlacDao() {
        if(this.ilacDao==null)
            this.ilacDao=new IlacDao();
        return ilacDao;
    }

    public void setIlacDao(IlacDao ilacDao) {
        this.ilacDao = ilacDao;
    }
    
}
