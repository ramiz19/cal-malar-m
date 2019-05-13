/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.converter;

import admin.dao.MuayeneDao;
import entity.Muayene;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cemr_
 */
@FacesConverter(value="muayeneConverter")
public class muayeneConverter implements Converter{

    private MuayeneDao muayenedao;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getMuayenedao().detail(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Muayene m=(Muayene) value;
        return m.getMuayene_id().toString();
    }

    public MuayeneDao getMuayenedao() {
        if(this.muayenedao==null)
            this.muayenedao=new MuayeneDao();
        return muayenedao;
    }

    public void setMuayenedao(MuayeneDao muayenedao) {
        this.muayenedao = muayenedao;
    }
    
}
