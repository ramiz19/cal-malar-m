/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Groups;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface GroupsFacadeImplLocal {

    public List<Groups> findAll();

    public void create(Groups obj);

    public void edit(Groups obj);

    public void remove(Groups obj);
    
}
