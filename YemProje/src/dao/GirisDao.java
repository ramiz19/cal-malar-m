/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cemr_
 */
public class GirisDao extends Dao{

       
 public boolean girisYap(String Kullanici, String Parola) {
       
        String sorgu = "select * from adminler where user_name=? and password=?";
        
        try {
           PreparedStatement preparedStatement = this.getConnection().prepareStatement(sorgu);
            
            preparedStatement.setString(1, Kullanici);
            preparedStatement.setString(2, Parola);
            
            ResultSet rs =  preparedStatement.executeQuery();
          /*  
            if (rs.next() == false) {
                return false;
            }else{
                return true;
            }
            */
          
          return rs.next();//true değer dondurur
          
          
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
       
    
}
