/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Stock;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface StockFacadeImplLocal {

    public List<Stock> findAll();

    public void edit(Stock stock);

    public void remove(Stock stock);

    public void create(Stock stock);

    
}
