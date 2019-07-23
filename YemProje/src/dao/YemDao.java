/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Yem;
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
public class YemDao extends Dao {

    public ArrayList<Yem> yemListeleme() {
        ArrayList<Yem> yemList = new ArrayList<>();

        String sorgu = "select * from yem order by id";

        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
            ResultSet rs = pst.executeQuery();

            if (true) {
                while (rs.next()) {
                    Yem yem = new Yem();
                    yem.setId(rs.getLong("id"));
                    yem.setYemKategori(rs.getString("yem_kategori"));
                    yem.setYemFiyat(rs.getString("yem_fiyat"));
                    yem.setYemAdet(rs.getString("yem_adet"));
                    yem.setYemMiktar(rs.getString("yem_miktar"));
                    yem.setGelmeTarihi(rs.getString("gelme_tarihi"));

                    yemList.add(yem);
                }

            } else {
                System.out.println("////////////////////hata////////////////////////");
            }
            return yemList;

        } catch (SQLException ex) {
            Logger.getLogger(YemDao.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }

    public void ekleYem(String kategori, String fiyat, String adet, String miktar, String tarih) {
       String sorgu = "insert into yem (yem_kategori,yem_fiyat,yem_adet,yem_miktar,gelme_tarihi) values(?,?,?,?,?)";
       
        if (true) {
           try {
               PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
               pst.setString(1, kategori);
               pst.setString(2, fiyat);
               pst.setString(3, adet);
               pst.setString(4, miktar);
               pst.setString(5, tarih);
               
               pst.executeUpdate();
               
           } catch (SQLException ex) {
               Logger.getLogger(YemDao.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else{
            System.out.println("////////////Kodda bir hata var////////////");
        }
    }

    public void guncelleYem(long id, String kategori, String fiyat, String adet, String miktar, String tarih) {
         String sorgu = "update yem set yem_kategori=?,yem_fiyat=?,yem_adet=?,yem_miktar=?,gelme_tarihi=?"
                 + "where id=?";
       
        if (true) {
           try {
               PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
               pst.setString(1, kategori);
               pst.setString(2, fiyat);
               pst.setString(3, adet);
               pst.setString(4, miktar);
               pst.setString(5, tarih);
               pst.setLong(6, id);
               
               pst.executeUpdate();
               
           } catch (SQLException ex) {
               Logger.getLogger(YemDao.class.getName()).log(Level.SEVERE, null, ex);
           }
        }else{
            System.out.println("////////////Kodda bir hata var////////////");
        }
    }

    public void silYem(long id) throws SQLException {
       String sorgu = "delete from yem where id=?";
      if (true) {
            try {
                PreparedStatement pst = this.getConnection().prepareStatement(sorgu);

                pst.setLong(1, id);

                pst.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(YemDao.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }else{
            System.out.println("//////////////////////////hata/////////////////////////");
        }
       
    }

    public boolean kontrolYap(String kategori, String fiyat, String adet, String miktar, String tarih) {
       
        
       String sorgu = "select * from yem where yem_kategori='" + kategori + "' and yem_fiyat='" + fiyat +
               "' and yem_adet='"+adet+"' and yem_miktar='"+miktar+"'and gelme_tarihi='"+tarih+"'";
       
      
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
