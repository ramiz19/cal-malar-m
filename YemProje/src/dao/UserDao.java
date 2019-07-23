/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cemr_
 */
public class UserDao extends Dao{

    public ArrayList<User> userList() {
        ArrayList<User> users = new ArrayList<>();
        
        String sorgu = "select * from user order by id";
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {                
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void ekleUser(String kullanici, String parola) {
       String sorgu = "insert into user (user_name,password) values(?,?)";
       
        if (true) {
           try {
               PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
               pst.setString(1, kullanici);
               pst.setString(2, parola);
               
               
               pst.executeUpdate();
               
           } catch (SQLException ex) {
               Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else{
            System.out.println("////////////Kodda bir hata var////////////");
        }
    }

    public void guncelleUser(long id, String kullanici, String parola) {
        String sorgu = "update user set user_name=?,password=? where id=?";
       
        if (true) {
           try {
               PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
               pst.setString(1, kullanici);
               pst.setString(2, parola);
               pst.setLong(3, id);
               
               
               pst.executeUpdate();
               
           } catch (SQLException ex) {
               Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else{
            System.out.println("////////////Kodda bir hata var////////////");
        }
    }

    public void silUser(long id) {
       String sorgu = "delete from user where id=?";
      if (true) {
            try {
                PreparedStatement pst = this.getConnection().prepareStatement(sorgu);

                pst.setLong(1, id);

                pst.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }else{
            System.out.println("//////////////////////////hata/////////////////////////");
        }
       
    }

    public boolean girisYap(String Kullanici, String Parola) {
         String sorgu = "select * from user  where user_name=? and password=?";
        
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

    public boolean kontrolYap(String kullanici, String parola) {
       String sorgu = "select * from user where user_name='" + kullanici + "' and password='" + parola + "'";
       
      
        try {
           Statement st = this.getConnection().createStatement();
             ResultSet rs = st.executeQuery(sorgu);
             
             if (rs.next()) {
               return false;

                   
            }
             
             else{
                 return true;
             } 
        } catch (SQLException ex) {
            Logger.getLogger(YemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true;
    }

 
    }
    

