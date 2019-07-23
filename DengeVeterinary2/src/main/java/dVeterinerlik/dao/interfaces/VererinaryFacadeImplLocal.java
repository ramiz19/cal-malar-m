/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Veterinary;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface VererinaryFacadeImplLocal {

    public void create(Veterinary obj);

    public void remove(Veterinary obj);

    public void edit(Veterinary obj);

    public List<Veterinary> findAll();

}
