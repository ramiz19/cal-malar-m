/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Institution;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface InstitutionFacadeImplLocal {
     void create(Institution obj);

    void edit(Institution obj);

    void remove(Institution obj);

    List<Institution> findAll();

    Institution find(Object id);
    
}
