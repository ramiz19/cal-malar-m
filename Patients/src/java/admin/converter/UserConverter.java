/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.converter;

import admin.dao.UserDao;
import entity.User;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author cemr_
 */
@FacesConverter(value = "userConverter")
public class UserConverter implements Converter {

    private UserDao userdao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        return this.getUserdao().find(Long.valueOf(value));

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        User u = (User) value;
        return u.getUser_id().toString();

    }

    public UserDao getUserdao() {
        if (userdao == null) {
            this.userdao = new UserDao();
        }
        return userdao;
    }

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }

}
