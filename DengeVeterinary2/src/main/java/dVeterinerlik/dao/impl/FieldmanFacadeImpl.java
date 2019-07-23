/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.FieldmanFacadeImplLocal;
import dVeterinerlik.entity.Fieldman;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class FieldmanFacadeImpl extends BaseFacade<Fieldman> implements FieldmanFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public FieldmanFacadeImpl() {
        super(Fieldman.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
