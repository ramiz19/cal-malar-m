/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.GroupsFacadeImplLocal;
import dVeterinerlik.entity.Groups;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class GroupsFacadeImpl extends BaseFacade<Groups> implements GroupsFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public GroupsFacadeImpl() {
        super(Groups.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
