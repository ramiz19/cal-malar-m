/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.AccountingFacadeImplLocal;
import dVeterinerlik.entity.Accounting;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class AccountingFacadeImpl extends BaseFacade<Accounting> implements AccountingFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public AccountingFacadeImpl() {
        super(Accounting.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
