/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.SecretaryFacadeImplLocal;
import dVeterinerlik.entity.Secretary;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class SecretaryFacadeImpl extends BaseFacade<Secretary> implements SecretaryFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public SecretaryFacadeImpl() {
        super(Secretary.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
