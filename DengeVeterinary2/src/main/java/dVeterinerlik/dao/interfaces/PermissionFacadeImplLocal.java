/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Groups;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface PermissionFacadeImplLocal {

    public boolean hasPerm(Groups g, String module, String process);
    
}
