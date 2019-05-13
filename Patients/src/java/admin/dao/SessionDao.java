/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import entity.User;
import entity.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utility.Connector;

/**
 *
 * @author cemr_
 */
public class SessionDao {
      
    //database erişen sınıflar
    private Connector connector;
    private Connection connection;
    
    private RoleDao roleDao;
    /*
    public User login(String username, String password) {
        User tmp = null;
        try {
            //Connection c = ConnectionManager.getConnection();
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from user where user_name='" + username + "' and password='" + password + "'");

            if (rs.next()) {

                User u = new User();
                u.setUser_id(rs.getLong("user_id"));
                u.setUser_name(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                
                u.setRole_entity(this.getRoleDao().find(rs.getLong("role_id")));
                tmp = u;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }
*/
    
     public boolean getPerm(UserRole role, String module, String process) {
          try {
            //Connection c = ConnectionManager.getConnection();
            PreparedStatement pst = this.getConnection().prepareStatement("select * from yetkilendirme where role_id=? and module=? and " +process+" =true");
            
            pst.setLong(1,role.getRole_id());
            pst.setString(2, module);
            
            ResultSet rs = pst.executeQuery();
            

            if (rs.next()) {

              return true;
               // u.setRole_entity(this.getRoleDao().find(rs.getLong("role_id")));
         
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        return false;
     }
     
     
    
    

    
        public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public RoleDao getRoleDao() {
        if(this.roleDao==null)
            this.roleDao=new RoleDao();
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

   
   

   
    
    
}
