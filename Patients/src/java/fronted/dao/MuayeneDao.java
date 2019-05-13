/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fronted.dao;

import admin.dao.*;
import entity.Ilac;
import entity.Muayene;
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
public class MuayeneDao {

    private DoktorDao doktordao;
    private HastaDao hastadao;

    private IlacDao ilacdao;

    private Connector connector;
    private Connection connection;

    public List<Muayene> findAll(int page, int count) {
        List<Muayene> muayeneList = new ArrayList<>();

        int start = (page - 1) * count;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from muayene order by muayene_id limit " + start + "," + count);//veritabanından tablonun verilerini cekmek..
            ResultSet rs = pst.executeQuery();//sorguları getirme.....
            //tüm verileri cekme...bircok sonuc döndürme...
            while (rs.next()) {

                Muayene tmp = new Muayene();
                tmp.setMuayene_id(rs.getLong("muayene_id"));
                tmp.setTeshis(rs.getString("teshis"));
                tmp.setDoktor_entity(this.getDoktordao().find(rs.getLong("doktor_id")));
                tmp.setHasta_entity(this.getHastadao().detail(rs.getLong("hasta_id")));

                tmp.setMuayene_ilac(this.getIlacdao().getMuayeneilac(tmp.getMuayene_id()));

                muayeneList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return muayeneList;
    }

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from muayene");//veritabanından tablonun verilerini cekmek..
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c++;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }

    public void update(Muayene muayene) {
        try {

            PreparedStatement pst;
            pst = this.getConnection().prepareStatement("update muayene set teshis=?, "
                    + "doktor_id=?, hasta_id=? where muayene_id=? ");
            pst.setString(1, muayene.getTeshis());
            pst.setLong(2, muayene.getDoktor_entity().getDoktor_id());
            pst.setLong(3, muayene.getHasta_entity().getHasta_id());
            pst.setLong(4, muayene.getMuayene_id());

            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from muayene_ilac where muayene_id=?");
            pst.setLong(1, muayene.getMuayene_id());
            pst.executeUpdate();

            for (Ilac i : muayene.getMuayene_ilac()) {
                pst = this.getConnection().prepareStatement("insert into muayene_ilac (muayene_id, ilac_id)values(?,?)");
                pst.setLong(1, muayene.getMuayene_id());
                pst.setLong(2, i.getIlac_id());
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void insert(Muayene muayene) {
        try {

            PreparedStatement pst;
            pst = this.getConnection().prepareStatement("insert into muayene (teshis,doktor_id, hasta_id) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, muayene.getTeshis());
            pst.setLong(2, muayene.getDoktor_entity().getDoktor_id());
            pst.setLong(3, muayene.getHasta_entity().getHasta_id());

            pst.executeUpdate();

            Long muayene_id = null;//muayene_id yi alabilmek için gk kullanırırz..
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                muayene_id = gk.getLong(1);
            }

            //muayene_ilac tablosuna n tane ekleme yapmak için kullanılan metod...
            for (Ilac i : muayene.getMuayene_ilac()) {
                pst = this.getConnection().prepareStatement("insert into muayene_ilac (muayene_id, ilac_id)values(?,?)", Statement.RETURN_GENERATED_KEYS);

                pst.setLong(1, muayene_id);
                pst.setLong(2, i.getIlac_id());
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void delete(Muayene muayene) {
        try {

            PreparedStatement pst2;
            pst2 = this.getConnection().prepareStatement("delete from muayene_ilac where muayene_id=?");
            pst2.setLong(1, muayene.getMuayene_id());
            pst2.executeUpdate();

            PreparedStatement pst;
            pst = this.getConnection().prepareStatement("delete from muayene where muayene_id=?");
            pst.setLong(1, muayene.getMuayene_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public Muayene detail(Long id) {
        Muayene muayene = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from muayene where muayene_id= " + id);
            rs.next();

            muayene = new Muayene();

            muayene.setMuayene_id(rs.getLong("muayene_id"));
            muayene.setTeshis(rs.getString("teshis"));
            muayene.setDoktor_entity(this.getDoktordao().find(rs.getLong("doktor_id")));//
            muayene.setHasta_entity(this.getHastadao().detail(rs.getLong("hasta_id")));//tekbir tane hasta_id getirmesi için...

            muayene.setMuayene_ilac(this.getIlacdao().getMuayeneilac(muayene.getMuayene_id()));//

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return muayene;
    }

    //n-n ilşki metodu..bu metod ilacda muayeneleri listeler..
    public List<Muayene> getIlacmuayene(Long ilac_id) {
        List<Muayene> ilacMuayene = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from muayene_ilac where ilac_id=" + ilac_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ilacMuayene.add(this.detail(rs.getLong("muayene_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ilacMuayene;
    }

    //1-n ilişki metodu...bu metod hastada muayeneleri listeler..
    public List<Muayene> getHastamuayene(Long hasta_id) {
        List<Muayene> muayeneHasta = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from muayene where hasta_id= " + hasta_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                muayeneHasta.add(this.detail(rs.getLong("muayene_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return muayeneHasta;
    }
    //1-n ilişki metodu...bu metod doktorda muayeneleri listeler..

    public List<Muayene> getDoktormuayene(Long doktor_id) {
        List<Muayene> muayeneDoktor = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from muayene where doktor_id= " + doktor_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                muayeneDoktor.add(this.detail(rs.getLong("muayene_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return muayeneDoktor;
    }

    ///////////////////PAGENATİON//////////////////////////////////////////////
    public int itemCount() {

        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (muayene_id) as muayene_count from muayene");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("muayene_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;

    }
    ///////////////////PAGENATİON//////////////////////////////////////////////

    public DoktorDao getDoktordao() {
        if (this.doktordao == null) {
            this.doktordao = new DoktorDao();
        }
        return doktordao;
    }

    public void setDoktordao(DoktorDao doktordao) {
        this.doktordao = doktordao;
    }

    public HastaDao getHastadao() {
        if (this.hastadao == null) {
            this.hastadao = new HastaDao();
        }
        return hastadao;
    }

    public void setHastadao(HastaDao hastadao) {
        this.hastadao = hastadao;
    }

    public IlacDao getIlacdao() {
        if (this.ilacdao == null) {
            this.ilacdao = new IlacDao();
        }
        return ilacdao;
    }

    public void setIlacdao(IlacDao ilacdao) {
        this.ilacdao = ilacdao;
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

    public Connection getConnection() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    /*
    private void closeConnection() throws SQLException {
        if(this.connection==null)
            this.connection.isClosed();
    }
     */

}
