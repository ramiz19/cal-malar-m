/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.Connector;

/**
 *
 * @author cemr_
 */
public class FileDao {
    private Connector connector;
    private Connection connection;

    public void insert(SystemFiles sf) {
        try{
            PreparedStatement pst =this.getConnection().prepareStatement("insert into dosya(file_path,file_name,file_type)values(?,?,?)");
            pst.setString(1, sf.getFile_path());
            pst.setString(2, sf.getFile_name());
            pst.setString(3, sf.getFile_type());
            
            pst.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
        public List<SystemFiles> list() {
            List<SystemFiles>fileList=new ArrayList<>();
            try{
               PreparedStatement pst =this.getConnection().prepareStatement("select * from dosya"); 
               ResultSet rs = pst.executeQuery();
               while(rs.next()){
                   SystemFiles sf=new SystemFiles();
                   sf.setFile_path(rs.getString("file_path"));
                   sf.setFile_name(rs.getString("file_name"));
                   sf.setFile_type(rs.getString("file_type"));
                   
                   fileList.add(sf);
               }
            }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
            return fileList;
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


    
}
