/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.InstitutionFacadeImplLocal;
import dVeterinerlik.entity.Institution;
import javax.ejb.Stateless;

/**
 *
 * @author Alaa SHATTI
 */
@Stateless
public class InstitutionFacadeImpl extends BaseFacade<Institution> implements InstitutionFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public InstitutionFacadeImpl() {
        super(Institution.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
