/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fronted.dao;

import admin.dao.*;
import entity.Doktor;
import entity.Poliklinik;
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
public class KlinikDAO {

    private Connector connector;
    private Connection connection;

    private RandevuDao randevuDao;
    private DoktorDao doktorDao;

    public List<Poliklinik> findALL(int page, int count) {
        List<Poliklinik> klinikList = new ArrayList<>();

        int start = (page - 1) * count;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from poliklinik order by klinik_id limit " + start + "," + count);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Poliklinik tmp = new Poliklinik();
                tmp.setKlinik_id(rs.getLong("klinik_id"));
                tmp.setKlinik_name(rs.getString("klinik_name"));
                tmp.setKlinik_bilgi(rs.getString("klinik_bilgi"));

                tmp.setDoktor_entity(this.getDoktorDao().getKlinikdoktor(tmp.getKlinik_id()));
                tmp.setRandevu_entity(this.getRandevuDao().getKlinik_randevu(tmp.getKlinik_id()));

                klinikList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return klinikList;
    }
    
    
    public List<Poliklinik> findALL() {
        List<Poliklinik> klinikList = new ArrayList<>();


        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from poliklinik");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Poliklinik tmp = new Poliklinik();
                tmp.setKlinik_id(rs.getLong("klinik_id"));
                tmp.setKlinik_name(rs.getString("klinik_name"));
                tmp.setKlinik_bilgi(rs.getString("klinik_bilgi"));

                tmp.setDoktor_entity(this.getDoktorDao().getKlinikdoktor(tmp.getKlinik_id()));
                tmp.setRandevu_entity(this.getRandevuDao().getKlinik_randevu(tmp.getKlinik_id()));

                klinikList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return klinikList;
    }

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from poliklinik");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               c++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public void insert(Poliklinik klinik) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into poliklinik ( klinik_name, klinik_bilgi ) values (?,?)", Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, klinik.getKlinik_name());
            pst.setString(2, klinik.getKlinik_bilgi());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Poliklinik klinikdelete) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from poliklinik where klinik_id= " + klinikdelete.getKlinik_id());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Poliklinik klinik) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update  poliklinik set  klinik_name= '" + klinik.getKlinik_name() + "'"
                    + ",klinik_bilgi= '" + klinik.getKlinik_bilgi() + "' "
                    + "where klinik_id= " + klinik.getKlinik_id());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Poliklinik detail(Long id) {
        Poliklinik klinik = null;

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from poliklinik where klinik_id= " + id);
            rs.next();
            Poliklinik tmp = new Poliklinik();
            tmp.setKlinik_id(rs.getLong("klinik_id"));
            tmp.setKlinik_name(rs.getString("klinik_name"));
            tmp.setKlinik_bilgi(rs.getString("klinik_bilgi"));

            klinik = tmp;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return klinik;
    }

    public Poliklinik find(int id) {
        Poliklinik klinik = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from poliklinik where klinik_id=" + id);
            rs.next();

            Poliklinik tmp = new Poliklinik();
            tmp.setKlinik_id(rs.getLong("klinik_id"));
            tmp.setKlinik_name(rs.getString("klinik_name"));
            tmp.setKlinik_bilgi(rs.getString("klinik_bilgi"));

            klinik = tmp;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return klinik;
    }

    ///////////////////PAGENATİON//////////////////////////////////////////////
    public int itemCount() {

        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (klinik_id) as klinik_count from poliklinik");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("klinik_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

    }
    ///////////////////PAGENATİON//////////////////////////////////////////////

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

    public RandevuDao getRandevuDao() {
        if (this.randevuDao == null) {
            this.randevuDao = new RandevuDao();
        }
        return randevuDao;
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

}
