/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.StockFacadeImplLocal;
import dVeterinerlik.entity.Stock;
import javax.ejb.Stateless;

/**
 *
 * @author Alaa SHATTI
 */
@Stateless
public class StockFacadeImpl extends BaseFacade<Stock> implements StockFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public StockFacadeImpl() {
        super(Stock.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
