/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import util.Database;

/**
 *
 * @author cemr_
 */
public class Dao {
      //database erişen sınıflar
    private Database database;
    private Connection connection;

    public Database getDatabase() {
        if(this.database==null)
            this.database=new Database();
        return database;
    }

    public void setConnector(Database connector) {
        this.database = connector;
    }

    public Connection getConnection() {
        if(this.connection==null)
           this.connection=this.getDatabase().connect();
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
