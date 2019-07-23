/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.AllEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface AllEntityFacadeImplLocal {

    public List<AllEntity> findAll();

    public void create(AllEntity obj);

    public void edit(AllEntity obj);
    
    
}
