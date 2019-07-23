/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Record;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface RecordFacadeImplLocal {

    void create(Record obj);

    void edit(Record obj);

    void remove(Record obj);

    List<Record> findAll();

    Record find(Object id);

}
