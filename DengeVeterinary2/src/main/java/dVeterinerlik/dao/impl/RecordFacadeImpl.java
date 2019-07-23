/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.impl;

import dVeterinerlik.dao.interfaces.RecordFacadeImplLocal;
import dVeterinerlik.entity.Record;
import javax.ejb.Stateless;

/**
 *
 * @author MS-PC
 */
@Stateless
public class RecordFacadeImpl extends BaseFacade<Record> implements RecordFacadeImplLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public RecordFacadeImpl() {
        super(Record.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
