/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Fieldman;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface FieldmanFacadeImplLocal {

    public void create(Fieldman obj);

    public void edit(Fieldman obj);

    public void remove(Fieldman obj);

    public Fieldman find(Object id);

    public List<Fieldman> findAll();
}
