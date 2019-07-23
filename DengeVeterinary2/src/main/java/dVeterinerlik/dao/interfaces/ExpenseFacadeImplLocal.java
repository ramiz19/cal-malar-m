/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Expense;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface ExpenseFacadeImplLocal {

    public List<Expense> findAll();

    public void create(Expense expense);

    public void edit(Expense expense);
    
    public void remove(Expense expense);

    
}
