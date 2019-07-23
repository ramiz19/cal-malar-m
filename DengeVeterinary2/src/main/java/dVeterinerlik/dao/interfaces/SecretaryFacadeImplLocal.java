/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Secretary;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface SecretaryFacadeImplLocal {

    public List<Secretary> findAll();

    public void create(Secretary secretary);

    public void edit(Secretary secretary);

    public void remove(Secretary secretary);
    
}
