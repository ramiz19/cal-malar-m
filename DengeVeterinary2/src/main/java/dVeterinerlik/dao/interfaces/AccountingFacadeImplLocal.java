/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Accounting;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface AccountingFacadeImplLocal {

    public void create(Accounting obj);

    public void edit(Accounting obj);

    public void remove(Accounting obj);

    public Accounting find(Object id);

    public List<Accounting> findAll();
    
    public int count();

}
