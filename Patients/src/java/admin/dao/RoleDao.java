/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import entity.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utility.Connector;

/**
 *
 * @author cemr_
 */
public class RoleDao {

    private Connector connector;
    private Connection connection;

    private UserDao userDao;

    public int kayitSay() {

        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from user_role");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                c++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public List<UserRole> findAll(int page, int count) {
        List<UserRole> roleList = new ArrayList<>();

        int start = (page - 1) * count;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from user_role order by role_id limit " + start + "," + count);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                UserRole tmp = new UserRole();
                tmp.setRole_id(rs.getLong("role_id"));
                tmp.setRole_name(rs.getString("role_name"));
                tmp.setRole_bilgi(rs.getString("role_bilgi"));

                tmp.setUser_entity(this.getUserDao().getUser_role(tmp.getRole_id()));

                roleList.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return roleList;

    }

    public void insert(UserRole role1) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into user_role (role_name, role_bilgi) values(?,?)");
            pst.setString(1, role1.getRole_name());
            pst.setString(2, role1.getRole_bilgi());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(UserRole roledelete) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from user_role where role_id=" + roledelete.getRole_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(UserRole role1) {//sart vermezsek tablonun hepsini gunceller...

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update user_role set role_name=?, role_bilgi=? where role_id=?");
            pst.setString(1, role1.getRole_name());
            pst.setString(2, role1.getRole_bilgi());
            pst.setLong(3, role1.getRole_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    //ilişki metodu...tek bir tane atribut cekmek için...
    public UserRole find(Long id) {
        UserRole usrole = null;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from user_role where role_id= " + id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            usrole = new UserRole();
            usrole.setRole_id(rs.getLong("role_id"));
            usrole.setRole_name(rs.getString("role_name"));
            usrole.setRole_bilgi(rs.getString("role_bilgi"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return usrole;

    }

    public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (role_id) as role_count from user_role");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("role_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public UserDao getUserDao() {
        if (this.userDao == null) {
            this.userDao = new UserDao();
        }
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
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
