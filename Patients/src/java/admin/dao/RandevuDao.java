/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import entity.Randevu;
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
public class RandevuDao {

    private Connector connector;
    private Connection connection;

    private HastaDao hastaDao;
    private KlinikDAO klinikDao;

    public List<Randevu> findAll(int page, int count) {
        List<Randevu> randevuList = new ArrayList<>();

        int start = (page - 1) * count;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from randevu order by randevu_id limit " + start + "," + count);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Randevu tmp = new Randevu();
                tmp.setRandevu_id(rs.getLong("randevu_id"));
                tmp.setSikayet(rs.getString("sikayet"));
                tmp.setTarih(rs.getString("tarih"));
                tmp.setSaat(rs.getString("saat"));

                tmp.setHasta_entity(this.getHastaDao().detail(rs.getLong("hasta_id")));
                tmp.setKlinik_entity(this.getKlinikDao().detail(rs.getLong("klinik_id")));

                randevuList.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return randevuList;
    }

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from randevu");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            c++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

    public void insert(Randevu randevu) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into randevu (sikayet,tarih,saat,hasta_id,klinik_id) values(?,?,?,?,?)");
            pst.setString(1, randevu.getSikayet());
            pst.setString(2, randevu.getTarih());
            pst.setString(3, randevu.getSaat());

            pst.setLong(4, randevu.getHasta_entity().getHasta_id());
            pst.setLong(5, randevu.getKlinik_entity().getKlinik_id());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Randevu randevu) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update  randevu set sikayet=?,tarih=?,saat=?,hasta_id=?,klinik_id=? where randevu_id=?");
            pst.setString(1, randevu.getSikayet());
            pst.setString(2, randevu.getTarih());
            pst.setString(3, randevu.getSaat());

            pst.setLong(4, randevu.getHasta_entity().getHasta_id());
            pst.setLong(5, randevu.getKlinik_entity().getKlinik_id());
            pst.setLong(6, randevu.getRandevu_id());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Randevu deleteRandevu) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from randevu where randevu_id=?");
            pst.setLong(1, deleteRandevu.getRandevu_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Randevu find(Long id) {
        Randevu randevu = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from randevu where randevu_id=" + id);

            ResultSet rs = pst.executeQuery();
            rs.next();

            Randevu tmp = new Randevu();
            tmp.setRandevu_id(rs.getLong("randevu_id"));
            tmp.setSikayet(rs.getString("sikayet"));
            tmp.setTarih(rs.getString("tarih"));
            tmp.setSaat(rs.getString("saat"));
            tmp.setHasta_entity(this.getHastaDao().detail(rs.getLong("hasta_id")));
            tmp.setKlinik_entity(this.getKlinikDao().detail(rs.getLong("klinik_id")));

            randevu = tmp;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return randevu;
    }

    public List<Randevu> getHasta_randevu(Long hasta_id) {
        List<Randevu> randevuHasta = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from randevu where hasta_id=" + hasta_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                randevuHasta.add(this.find(rs.getLong("randevu_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return randevuHasta;
    }

    public List<Randevu> getKlinik_randevu(Long klinik_id) {
        List<Randevu> randevuKlinik = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from randevu where klinik_id=" + klinik_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                randevuKlinik.add(this.find(rs.getLong("randevu_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return randevuKlinik;
    }

    ///////////////////PAGENATİON//////////////////////////////////////////////
    public int itemCount() {

        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (randevu_id) as randevu_count from randevu");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("randevu_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

    }
    ///////////////////PAGENATİON//////////////////////////////////////////////

    public HastaDao getHastaDao() {
        if (this.hastaDao == null) {
            this.hastaDao = new HastaDao();
        }
        return hastaDao;
    }

    public void setHastaDao(HastaDao hastaDao) {
        this.hastaDao = hastaDao;
    }

    public KlinikDAO getKlinikDao() {
        if (this.klinikDao == null) {
            this.klinikDao = new KlinikDAO();
        }
        return klinikDao;
    }

    public void setKlinikDao(KlinikDAO klinikDao) {
        this.klinikDao = klinikDao;
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
