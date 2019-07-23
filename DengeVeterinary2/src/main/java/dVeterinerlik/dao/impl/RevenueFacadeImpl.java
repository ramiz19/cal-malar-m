/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.RevenueFacadeImplLocal;
import dVeterinerlik.entity.Revenue;
import javax.ejb.Stateless;

/**
 *
 * @author ِAlaa SHATTI
 */
@Stateless
public class RevenueFacadeImpl extends BaseFacade<Revenue> implements RevenueFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public RevenueFacadeImpl() {
        super(Revenue.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
