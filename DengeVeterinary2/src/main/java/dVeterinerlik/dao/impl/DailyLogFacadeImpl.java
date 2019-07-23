/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.DailyLogFacadeImplLocal;
import dVeterinerlik.entity.DailyLog;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class DailyLogFacadeImpl extends BaseFacade<DailyLog> implements DailyLogFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public DailyLogFacadeImpl() {
        super(DailyLog.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
