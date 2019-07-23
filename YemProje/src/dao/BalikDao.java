/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Balik;
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
public class BalikDao extends Dao {

    public ArrayList<Balik> balikList() {
        ArrayList<Balik> balikList = new ArrayList<>();

        String sorgu = "select * from balik order by id";

        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Balik balik = new Balik();
                balik.setId(rs.getLong("id"));
                balik.setBalikCinsi(rs.getString("balik_cinsi"));
                balik.setBalikFiyat(rs.getString("balik_fiyat"));
                balik.setKilo(rs.getString("kilo"));
                balik.setBoy(rs.getString("boy"));
                balik.setYemKategori(rs.getString("yem_kategori"));
                balik.setYemKilo(rs.getString("yem_kilo"));
                balik.setGetirilisTarihi(rs.getString("getirilis_tarihi"));

                balikList.add(balik);
            }

            return balikList;
        } catch (SQLException ex) {
            Logger.getLogger(BalikDao.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }

    }

    public void ekleBalik(String cins, String fiyat, String kilo, String boy, String kategori, String yem_kilo, String tarih) {

        String sorgu = "insert into balik (balik_cinsi,balik_fiyat,kilo,boy,yem_kategori,yem_kilo,getirilis_tarihi) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
            pst.setString(1, cins);
            pst.setString(2, fiyat);
            pst.setString(3, kilo);
            pst.setString(4, boy);
            pst.setString(5, kategori);
            pst.setString(6, yem_kilo);
            pst.setString(7, tarih);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BalikDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guncelleBalik(long id, String cins, String fiyat, String kilo, String boy, String kategori, String yem_kilo, String tarih) {
        String sorgu = "update balik set balik_cinsi=?,balik_fiyat=?,kilo=?,boy=?,yem_kategori=?,yem_kilo=?,getirilis_tarihi=?"
                + "where id=?";

        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
            pst.setString(1, cins);
            pst.setString(2, fiyat);
            pst.setString(3, kilo);
            pst.setString(4, boy);
            pst.setString(5, kategori);
            pst.setString(6, yem_kilo);
            pst.setString(7, tarih);
            pst.setLong(8, id);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BalikDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void silBalik(long id) {
        String sorgu = "delete from balik where id=?";
        if (true) {
            try {
                PreparedStatement pst = this.getConnection().prepareStatement(sorgu);

                pst.setLong(1, id);

                pst.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(BalikDao.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }else{
            System.out.println("//////////////////////////hata/////////////////////////");
        }

    }

    public boolean kontrolYap(String cins, String kilo, String boy, String tarih) {
         String sorgu = "select * from balik where balik_cinsi='" + cins + "' and kilo='" + kilo +
               "' and boy='"+boy+"' and getirilis_tarihi='"+tarih+"'";
       
      
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
