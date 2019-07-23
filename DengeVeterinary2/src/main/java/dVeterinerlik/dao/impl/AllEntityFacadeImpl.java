/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.AllEntityFacadeImplLocal;
import dVeterinerlik.entity.AllEntity;
import javax.ejb.Stateless;

/**
 *
 * @author Alaa SHATTI
 */
@Stateless
public class AllEntityFacadeImpl extends BaseFacade<AllEntity> implements AllEntityFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public AllEntityFacadeImpl() {
        super(AllEntity.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
