/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.DailyLog;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface DailyLogFacadeImplLocal {

    public List<DailyLog> findAll();

    public void create(DailyLog obj);

    public void edit(DailyLog obj);

    public void remove(DailyLog obj);

    DailyLog find(Object id);

}
