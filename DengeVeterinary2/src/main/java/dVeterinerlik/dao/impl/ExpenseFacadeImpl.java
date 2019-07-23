/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.ExpenseFacadeImplLocal;
import dVeterinerlik.entity.Expense;
import javax.ejb.Stateless;

/**
 *
 * @author Alaa SHATTI
 */
@Stateless
public class ExpenseFacadeImpl extends BaseFacade<Expense> implements ExpenseFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public ExpenseFacadeImpl() {
        super(Expense.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
