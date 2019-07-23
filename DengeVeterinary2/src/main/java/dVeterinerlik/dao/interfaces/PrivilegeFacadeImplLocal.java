/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Privilege;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface PrivilegeFacadeImplLocal {

    public List<Privilege> findAll();

    public void create(Privilege obj);

    public void edit(Privilege obj);

    public void remove(Privilege obj);

}
