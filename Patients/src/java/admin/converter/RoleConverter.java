/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.converter;

import admin.dao.RoleDao;
import entity.UserRole;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cemr_
 */
@FacesConverter(value="roleConverter")
public class RoleConverter implements Converter{

    private RoleDao roleDao;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getRoleDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        UserRole r=(UserRole) value;
        return r.getRole_id().toString();
    }

    public RoleDao getRoleDao() {
        if(this.roleDao==null)
            this.roleDao=new RoleDao();
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    
}
