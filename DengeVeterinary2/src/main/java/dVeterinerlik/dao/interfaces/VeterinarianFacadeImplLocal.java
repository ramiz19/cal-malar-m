/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Veterinarian;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface VeterinarianFacadeImplLocal {

    public List<Veterinarian> findAll();

    public void edit(Veterinarian veterinarian);

    public void remove(Veterinarian veterinarian);

    public void create(Veterinarian veterinarian);

}
