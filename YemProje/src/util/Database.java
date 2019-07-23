/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cemr_
 */
public class Database {
   
    
    private static final String DbName = "yem_firma";
    
    private static final String Host = "localhost";
    
    private static final int Port = 3306;
    
    
    private static final String kullanici_ad = "root";
    
    private static final String Parola = "12qwaszx";

    public Connection connect() {
         Connection connection = null;
        String url = "jdbc:mysql://" + Database.getHost() + ":" + Database.getPort() + "/" + Database.getDbName() + 
                "?useUnicode=true&characterEncoding"; 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println("util.Database.connect()");
        }
        
        try {
            connection = DriverManager.getConnection(url, Database.getKullanici_ad(), Database.getParola());
            System.out.println("Bağlantı basarılı");
        } catch (SQLException ex) {
            System.out.println("Bağlantı basarısız");
            
            ex.printStackTrace();
        }
        return connection;
    }

    
    
    public static String getDbName() {
        return DbName;
    }

    public static String getHost() {
        return Host;
    }

    public static int getPort() {
        return Port;
    }

    public static String getKullanici_ad() {
        return kullanici_ad;
    }

    public static String getParola() {
        return Parola;
    }
    
    
    
}
