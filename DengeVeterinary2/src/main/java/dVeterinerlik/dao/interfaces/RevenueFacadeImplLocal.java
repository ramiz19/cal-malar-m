/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Revenue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface RevenueFacadeImplLocal {

    public List<Revenue> findAll();

    public void create(Revenue obj);

    public void edit(Revenue obj);

    public void remove(Revenue obj);

    Revenue find(Object id);

}
