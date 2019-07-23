/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Driver;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface DriverFacadeImplLocal {

    public List<Driver> findAll();

    public void create(Driver obj);

    public void remove(Driver obj);

    public void edit(Driver obj);

}
