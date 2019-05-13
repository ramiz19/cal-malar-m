/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fronted.dao;

import admin.dao.*;
import entity.Hasta;
import entity.User;

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
public class HastaDao {

    private Connector connector;
    private Connection connection;

    private RandevuDao randevuDao;
    private MuayeneDao muayeneDao;
    private UserDao userdao;

    public ArrayList<Hasta> findAll(int page, int count) {//listeleme metodu...
        ArrayList<Hasta> hastaList = new ArrayList<>();

        int start = (page - 1) * count;

        try {
            PreparedStatement st = this.getConnection().prepareStatement("select * from hasta order by hasta_id limit " + start + "," + count);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Hasta tmp = new Hasta();
                tmp.setHasta_id(rs.getLong("hasta_id"));
                tmp.setHasta_name(rs.getString("hasta_name"));
                tmp.setHasta_lastname(rs.getString("hasta_lastname"));
                tmp.setHasta_yas(rs.getLong("hasta_yas"));
                tmp.setUser_entity(this.getUserdao().find(rs.getLong("user_id")));
                tmp.setPhone(rs.getString("phone"));

                tmp.setMuayene_entity(this.getMuayeneDao().getHastamuayene(tmp.getHasta_id()));
                tmp.setRandevu_entity(this.getRandevuDao().getHasta_randevu(tmp.getHasta_id()));

                hastaList.add(tmp);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return hastaList;

    }

    public void insert(Hasta hasta1, int selectUser) {//create
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into hasta ( hasta_name, hasta_lastname, phone, hasta_yas, user_id ) values ( '" + ((Hasta) hasta1).getHasta_name() + "',"
                    + "'" + ((Hasta) hasta1).getHasta_lastname() + "' ,"
                    + "'" + ((Hasta) hasta1).getPhone() + "' ,"
                    + "'" + ((Hasta) hasta1).getHasta_yas() + "',"
                    + "" + selectUser + " )");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Hasta hasta1) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update hasta set hasta_name='" + ((Hasta) hasta1).getHasta_name() + "',"
                    + " hasta_lastname = '" + ((Hasta) hasta1).getHasta_lastname() + "',"
                    + "phone = '" + ((Hasta) hasta1).getPhone() + "',"
                    + " hasta_yas='" + ((Hasta) hasta1).getHasta_yas() + "',"
                    + " user_id = '" + ((Hasta) hasta1).getUser_entity().getUser_id() + "'"
                    + " where hasta_id=" + hasta1.getHasta_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Hasta deletehasta) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from hasta where hasta_id=    ?");
            pst.setLong(1, deletehasta.getHasta_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Hasta detail(Long id) {
        Hasta hasta = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from hasta where hasta_id= " + id);
            rs.next();//tek bir sonuc dondur...
            Hasta tmp = new Hasta();
            tmp.setHasta_id(rs.getLong("hasta_id"));
            tmp.setHasta_name(rs.getString("hasta_name"));
            tmp.setHasta_lastname(rs.getString("hasta_lastname"));
            tmp.setHasta_yas(rs.getLong("hasta_yas"));
            tmp.setUser_entity(this.getUserdao().find(rs.getLong("user_id")));
            tmp.setPhone(rs.getString("phone"));

            hasta = tmp;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return hasta;
    }

    public Hasta user_to_hasta(User user) {
        Hasta hasta = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from hasta where user_id= " + user.getUser_id());
            rs.next();
            
            Hasta tmp = new Hasta();
            tmp.setHasta_id(rs.getLong("hasta_id"));
            tmp.setHasta_name(rs.getString("hasta_name"));
            tmp.setHasta_lastname(rs.getString("hasta_lastname"));
            tmp.setHasta_yas(rs.getLong("hasta_yas"));
            tmp.setUser_entity(this.getUserdao().find(rs.getLong("user_id")));
            tmp.setPhone(rs.getString("phone"));

            hasta = tmp;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return hasta;
    }
    
    
    
    
    public Hasta getUserhasta(Long user_id) {
        Hasta hasta = new Hasta();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from hasta where user_id=" + user_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                hasta.setHasta_id(rs.getLong("hasta_id"));
                hasta.setHasta_name(rs.getString("hasta_name"));
                hasta.setHasta_lastname(rs.getString("hasta_lastname"));
                hasta.setHasta_yas(rs.getLong("hasta_yas"));
                hasta.setPhone(rs.getString("phone"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return hasta;

    }

    ///////////////////PAGENATİON//////////////////////////////////////////////
    public int itemCount() {

        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (hasta_id) as hasta_count from hasta");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("hasta_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

    }
    ///////////////////PAGENATİON//////////////////////////////////////////////

    public int kayitSay() {
        int c =0;
        try {
            PreparedStatement st = this.getConnection().prepareStatement("select * from hasta");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                c++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;

    }

    public RandevuDao getRandevuDao() {
        if (this.randevuDao == null) {
            this.randevuDao = new RandevuDao();
        }
        return randevuDao;
    }

    public MuayeneDao getMuayeneDao() {
        if (this.muayeneDao == null) {
            this.muayeneDao = new MuayeneDao();
        }
        return muayeneDao;
    }

    public void setMuayeneDao(MuayeneDao muayeneDao) {
        this.muayeneDao = muayeneDao;
    }

    public UserDao getUserdao() {
        if (this.userdao == null) {
            this.userdao = new UserDao();
        }

        return userdao;

    }

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
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
