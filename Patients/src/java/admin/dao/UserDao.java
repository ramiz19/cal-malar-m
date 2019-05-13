/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import entity.User;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.Connector;

/**
 *
 * @author cemr_
 */
public class UserDao {

    private Connector connector;
    private Connection connection;

    private RoleDao roledao;
    private HastaDao hastaDao;
    private DoktorDao doktorDao;

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    public User login2(User user) {
        User tmp = null;
        try {
            //Connection c = ConnectionManager.getConnection();
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from user where user_name='" + user.getUser_name() + "' and password='" + user.getPassword() + "'");

            if (rs.next()) {

                User u = new User();
                u.setUser_id(rs.getLong("user_id"));
                u.setUser_name(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setRole_entity(this.getRoledao().find(rs.getLong("role_id")));
                tmp = u;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

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
                u.setRole_entity(this.getRoledao().find(rs.getLong("role_id")));
                tmp = u;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

    private static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(password.getBytes("UTF-8"));

        return new BigInteger(1, crypt.digest()).toString(16);
    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from user");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               c++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    public List<User> findAll(int page, int count) {
        List<User> userList = new ArrayList<>();

        int start = (page - 1) * count;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from user order by user_id limit " + start + "," + count);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User tmp = new User();
                tmp.setUser_id(rs.getLong("user_id"));
                tmp.setUser_name(rs.getString("user_name"));
                tmp.setPassword(rs.getString("password"));
                tmp.setEmail(rs.getString("email"));

                tmp.setRole_entity(this.getRoledao().find(rs.getLong("role_id")));
                
                tmp.setHasta_entity(this.getHastaDao().getUserhasta(tmp.getUser_id()));
                tmp.setDoktor_entity(this.getDoktorDao().getUser_doktor(tmp.getUser_id()));

                userList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return userList;

    }

    public void insert(User user2) {
        try {

            Statement st2 = this.getConnection().createStatement();
            ResultSet rs = st2.executeQuery("select * from user");

            int say = 1;
            for (int i = 1; rs.next(); i++) {
                if (rs.getLong("user_id") == say) {
                    say++;
                    System.out.println("say= " + say);
                } else {
                    break;
                }

            }

            PreparedStatement pst = this.getConnection().prepareStatement("insert into user (user_id, user_name, password, email, role_id) values(?,?,?,?,?)");
            pst.setLong(1, say);
            pst.setString(2, user2.getUser_name());
            pst.setString(3, user2.getPassword());
            pst.setString(4, user2.getEmail());
            pst.setLong(5, user2.getRole_entity().getRole_id());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(User userdelete) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from user where user_id= " + userdelete.getUser_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(User user2) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate(
                    "update user set user_name='" + user2.getUser_name()
                    + "' , password='" + user2.getPassword()
                    + "' , email='" + user2.getEmail()
                    + "' , role_id=" + user2.getRole_entity().getRole_id()
                    + " where user_id=" + user2.getUser_id()
            );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public User find(Long id) {
        User user = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from user where user_id=" + id);
            rs.next();

            User tmp = new User();
            tmp.setUser_id(rs.getLong("user_id"));
            tmp.setUser_name(rs.getString("user_name"));
            tmp.setPassword(rs.getString("password"));
            tmp.setEmail(rs.getString("email"));
            tmp.setRole_entity(this.getRoledao().find(rs.getLong("role_id")));

            user = tmp;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    public User login(User u) {
        User user = null;
        try {

            String np = UserDao.encryptPassword(u.getPassword());

            Statement s = this.getConnection().createStatement();
            String sql = "select * from user where email='" + u.getEmail() + "' and password='" + np + "'";
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                User tmp = new User();
                tmp.setUser_id(rs.getLong("user_id"));
                tmp.setUser_name(rs.getString("user_name"));
                tmp.setPassword(rs.getString("password"));
                tmp.setEmail(rs.getString("email"));
                tmp.setRole_entity(this.getRoledao().find(rs.getLong("role_id")));

                user = tmp;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public List<User> getUser_role(Long role_id) {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from user where role_id=" + role_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                userList.add(this.find(rs.getLong("user_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userList;

    }

    ///////////////////PAGENATİON//////////////////////////////////////////////
    public int itemCount() {

        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (user_id) as user_count from user");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("user_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

    }
    ///////////////////PAGENATİON//////////////////////////////////////////////

    public RoleDao getRoledao() {
        if (this.roledao == null) {
            this.roledao = new RoleDao();
        }
        return roledao;
    }

    public void setRoledao(RoleDao roledao) {
        this.roledao = roledao;
    }

    public HastaDao getHastaDao() {
        if (this.hastaDao == null) {
            this.hastaDao = new HastaDao();
        }
        return hastaDao;
    }

    public void setHastaDao(HastaDao hastaDao) {
        this.hastaDao = hastaDao;
    }

    public DoktorDao getDoktorDao() {
        if (this.doktorDao == null) {
            this.doktorDao = new DoktorDao();
        }
        return doktorDao;
    }

    public void setDoktorDao(DoktorDao doktorDao) {
        this.doktorDao = doktorDao;
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
