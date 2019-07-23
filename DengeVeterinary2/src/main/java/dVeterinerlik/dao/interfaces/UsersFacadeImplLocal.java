/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dVeterinerlik.dao.interfaces;

import dVeterinerlik.entity.Groups;
import dVeterinerlik.entity.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alaa SHATTI
 */
@Local
public interface UsersFacadeImplLocal {

    public void create(Users obj);

    public void edit(Users obj);

    public void remove(Users obj);

    public List<Users> findAll();

    //Users find(Object id);                                              
    //List<Users> findRange(int[] range);                                 
    //List<Users> search(int[] range, String field, String term);      
    //int searchCount(String field, String term);                                
    public int count();

    //Users findByField(String field, String value);
    Users login(String email, String password);

    //public boolean hasPerm(Groups groups, String module, String process);

}
