package admin.dao;

import entity.Duyurular;
import utility.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DuyurularDao {

    private Connector connector;
    private Connection connection;

    Date dt;
    SimpleDateFormat spdate;
    private Duyurular duyurular = null;
    private ArrayList<Duyurular> dList = null;

    
    
    public Duyurular get(int id) {
        dt = new Date();
        spdate = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from duyurular where id=" + id);
            rs.next();
            this.duyurular = new Duyurular(rs.getInt("id"), rs.getString("duyuru"), rs.getString("tarih"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return this.duyurular;

    }

    public int kayitSay() {
        int c = 0;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from duyurular");
            while (rs.next()) {
                c++;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return c;
    }

    public ArrayList List(int page) {
        this.dList = new ArrayList();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from duyurular limit " + (page - 1) * 10 + " ,10");
            while (rs.next()) {
                this.dList.add(new Duyurular(rs.getInt("id"), rs.getString("duyuru"), rs.getString("tarih")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return this.dList;

    }

    public ArrayList List() {
        this.dList = new ArrayList();
        //spdate.format(rs.getTimestamp("tarih")) tarih converter yapılırsa.....
        dt = new Date();
        spdate = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from duyurular");
            while (rs.next()) {
                this.dList.add(new Duyurular(rs.getInt("id"), rs.getString("duyuru"), rs.getString("tarih")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return this.dList;

    }

    public ArrayList frontList() {
        this.dList = new ArrayList();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from duyurular order by tarih desc limit 5");

            while (rs.next()) {

                this.dList.add(new Duyurular(rs.getInt("id"), rs.getString("duyuru"), rs.getString("tarih")));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return this.dList;

    }

    public void delete(int id) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from duyurular where id=" + id);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Duyurular dy) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update duyurular set duyuru='" + dy.getDuyuru() + "' where id=" + dy.getId());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public void create(Duyurular dy) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into duyurular (duyuru,tarih) values ('" + dy.getDuyuru() + "','"+dy.getTarih()+"')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

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
