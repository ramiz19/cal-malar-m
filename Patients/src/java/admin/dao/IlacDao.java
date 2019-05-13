/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

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
public class IlacDao {

    private Connector connector;
    private Connection connection;

    private MuayeneDao muDao;

    public int kayitSay() {
        int c = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from ilac");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            c++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public List<Ilac> findAll(int page, int count) {
        List<Ilac> ilacList = new ArrayList<>();

        int start = (page - 1) * count;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from ilac order by ilac_id limit " + start + "," + count);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Ilac tmp = new Ilac();
                tmp.setIlac_id(rs.getLong("ilac_id"));
                tmp.setIlac_name(rs.getString("ilac_name"));
                tmp.setIlac_bilgi(rs.getString("ilac_bilgi"));

                tmp.setIlac_muayene(this.getMuDao().getIlacmuayene(tmp.getIlac_id()));

                ilacList.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ilacList;
    }

    public void insert(Ilac ilac2) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into ilac (ilac_name,ilac_bilgi) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, ilac2.getIlac_name());
            pst.setString(2, ilac2.getIlac_bilgi());
            pst.executeUpdate();

            Long ilac_id = null;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                ilac_id = gk.getLong(1);
            }
            for (Muayene m : ilac2.getIlac_muayene()) {
                pst = this.getConnection().prepareStatement("insert into muayene_ilac (muayene_id, ilac_id)values(?,?)", Statement.RETURN_GENERATED_KEYS);

                pst.setLong(1, m.getMuayene_id());
                pst.setLong(2, ilac_id);
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Ilac ilacdelete) {
        try {

            PreparedStatement pst2;
            pst2 = this.getConnection().prepareStatement("delete from muayene_ilac where ilac_id=?");
            pst2.setLong(1, ilacdelete.getIlac_id());
            pst2.executeUpdate();

            PreparedStatement pst;
            pst = this.getConnection().prepareStatement("delete from ilac where ilac_id=?");
            pst.setLong(1, ilacdelete.getIlac_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void update(Ilac ilac2) {
        try {

            PreparedStatement pst;
            pst = this.getConnection().prepareStatement("update ilac set ilac_name=?, "
                    + "ilac_bilgi=? where ilac_id=? ");
            pst.setString(1, ilac2.getIlac_name());
            pst.setString(2, ilac2.getIlac_bilgi());
            pst.setLong(3, ilac2.getIlac_id());

            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from muayene_ilac where ilac_id=?");
            pst.setLong(1, ilac2.getIlac_id());
            pst.executeUpdate();

            for (Muayene m : ilac2.getIlac_muayene()) {
                pst = this.getConnection().prepareStatement("insert into muayene_ilac (muayene_id, ilac_id)values(?,?)");
                pst.setLong(1, m.getMuayene_id());
                pst.setLong(2, ilac2.getIlac_id());
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    public Ilac detail(Long id) {
        Ilac ilac = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from ilac where ilac_id=" + id);

            ResultSet rs = pst.executeQuery();

            rs.next();
            Ilac tmp = new Ilac();
            tmp.setIlac_id(rs.getLong("ilac_id"));
            tmp.setIlac_name(rs.getString("ilac_name"));
            tmp.setIlac_bilgi(rs.getString("ilac_bilgi"));

            //muayene.setMuayene_ilac(this.getIlacdao().getMuayeneilac(muayene.getMuayene_id()));
            tmp.setIlac_muayene(this.getMuDao().getIlacmuayene(tmp.getIlac_id()));

            ilac = tmp;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ilac;
    }

    public Ilac find(Long id) {
        Ilac ilac = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from ilac where ilac_id=" + id);
            ResultSet rs = pst.executeQuery();

            rs.next();
            ilac = new Ilac();
            ilac.setIlac_id(rs.getLong("ilac_id"));
            ilac.setIlac_name(rs.getString("ilac_name"));
            ilac.setIlac_bilgi(rs.getString("ilac_bilgi"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return ilac;
    }

    public List<Ilac> getMuayeneilac(Long muayene_id) {
        List<Ilac> muayeneIlac = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from muayene_ilac where muayene_id=" + muayene_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                muayeneIlac.add(this.find(rs.getLong("ilac_id")));//1 muayenede ne kadar ilac varsa onları getir...
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return muayeneIlac;
    }

    ///////////////////////////////////////PAGENATİON///////////////////////////////
    public int itemCount() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count (ilac_id) as ilac_count from ilac");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("ilac_count");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    ///////////////////////////////////////PAGENATİON///////////////////////////////
    public MuayeneDao getMuDao() {
        if (this.muDao == null) {
            this.muDao = new MuayeneDao();
        }
        return muDao;
    }

    public void setMuDao(MuayeneDao muDao) {
        this.muDao = muDao;
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
