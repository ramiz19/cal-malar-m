/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.VeterinarianFacadeImplLocal;
import dVeterinerlik.entity.Veterinarian;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class VeterinarianFacadeImpl extends BaseFacade<Veterinarian> implements VeterinarianFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public VeterinarianFacadeImpl() {
        super(Veterinarian.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
