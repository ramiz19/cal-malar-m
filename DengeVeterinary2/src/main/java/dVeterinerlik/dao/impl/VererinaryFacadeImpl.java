/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.VererinaryFacadeImplLocal;
import dVeterinerlik.entity.Veterinary;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class VererinaryFacadeImpl extends BaseFacade<Veterinary> implements VererinaryFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public VererinaryFacadeImpl() {
        super(Veterinary.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
