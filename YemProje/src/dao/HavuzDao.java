/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Havuz;
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
public class HavuzDao extends Dao {

    public ArrayList<Havuz> havuzList() {
        ArrayList<Havuz> havuzs = new ArrayList<>();
        String sorgu = "select * from havuz order by id";

        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Havuz havuz = new Havuz();
                havuz.setId(rs.getLong("id"));
                havuz.setHavuzNo(rs.getInt("havuz_no"));
                havuz.setYemKategori(rs.getString("yem_kategori"));
                havuz.setYemMiktar(rs.getString("yem_miktar"));
                havuz.setBalikCinsi(rs.getString("balik_cinsi"));
                havuz.setHavuzdakiBalikSayisi(rs.getString("havuzdaki_balik_sayisi"));
                havuz.setAryatorSayisi(rs.getString("aryator_sayisi"));

                havuzs.add(havuz);
            }

            return havuzs;
        } catch (SQLException ex) {
            Logger.getLogger(BalikDao.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }

    public void ekleHavuz(String havuz_no, String kategori, String miktar, String balikCins,String balik_sayisi, String aryator) {
        String sorgu = "insert into havuz (havuz_no,yem_kategori,yem_miktar,balik_cinsi,havuzdaki_balik_sayisi,aryator_sayisi) values(?,?,?,?,?,?)";

        if (true) {
            try {
                PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
                pst.setString(1, havuz_no);
                pst.setString(2, kategori);
                pst.setString(3, miktar);
                pst.setString(4, balikCins);
                pst.setString(5, balik_sayisi);
                pst.setString(6, aryator);

                pst.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(YemDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("////////////Kodda bir hata var////////////");
        }
    }

    public void guncelleHavuz(long id, String havuz_no, String kategori, String miktar, String balikCins,String balik_sayisi, String aryator) {
        String sorgu = "update havuz set havuz_no=?,yem_kategori=?,yem_miktar=?,balik_cinsi=?,havuzdaki_balik_sayisi=?,aryator_sayisi=?"
                + "where id=?";

        if (true) {
            try {
                PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
                pst.setString(1, havuz_no);
                pst.setString(2, kategori);
                pst.setString(3, miktar);
                pst.setString(4, balikCins);
                pst.setString(5, balik_sayisi);
                pst.setString(6, aryator);
                pst.setLong(7, id);

                pst.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(YemDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("////////////Kodda bir hata var////////////");
        }
    }

    public void silHavuz(long id) {
        String sorgu = "delete from havuz where id=?";
        if (true) {
            try {
                PreparedStatement pst = this.getConnection().prepareStatement(sorgu);

                pst.setLong(1, id);

                pst.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(YemDao.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        } else {
            System.out.println("//////////////////////////hata/////////////////////////");
        }
    }

    public boolean kontrolYap(String havuz_no, String balikCins, String balikSayisi) {
        String sorgu = "select * from havuz where havuz_no='" + havuz_no + "' and balik_cinsi='" + balikCins +
               "' and havuzdaki_balik_sayisi='"+balikSayisi+"'";
       
      
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
