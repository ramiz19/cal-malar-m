/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fronted.dao;

import entity.Doktor;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.Connector;

/**
 *
 * @author cemr_
 */
public class DoktorDao {

    
    //database erişen sınıflar
    private Connector connector;
    private Connection connection;
    
    //ilişki sınıfları
    private KlinikDAO klinikdao;
    private UserDao userdao;
    private MuayeneDao muayeneDao;
    
     

        
    
    public int kayitSay() {//databaseden veri ceken metod...listeleme...
        int c=0;       
        try {
            PreparedStatement st = this.getConnection().prepareStatement("select * from doktor");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                c++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    
    public List<Doktor> findAll(int page, int count) {//databaseden veri ceken metod...listeleme...

        List<Doktor> doktorList = new ArrayList<>();
        
        int start=(page-1)*count;

        try {
            PreparedStatement st = this.getConnection().prepareStatement("select * from doktor order by doktor_id limit "+start+","+count);
            ResultSet rs = st.executeQuery();//resultset verileri cekerken ve sıralarken kullanılır..

            while (rs.next()) {//bircok veri olabilir...onun için while kullandık....
                Doktor dok = new Doktor();
                dok.setDoktor_id(rs.getLong("doktor_id"));
                dok.setDoktor_name(rs.getString("doktor_name"));
                dok.setDoktor_lastname(rs.getString("doktor_lastname"));
                dok.setUser_entity((User) this.getUserdao().find(rs.getLong("user_id")));
                dok.setKlinik_entity(this.getKlinikdao().detail(rs.getLong("klinik_id")));
                
                dok.setMuayene_entity(this.getMuayeneDao().getDoktormuayene(dok.getDoktor_id()));

                doktorList.add(dok);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return doktorList;
    }

    public Doktor find(Long id) {//bu metod bizim detail sayfamız ve ilşki işlemlerinde kullanılan metod...
        Doktor doktor = null;
        try {
            PreparedStatement st = this.getConnection().prepareStatement("select * from doktor where doktor_id= " + id);
            ResultSet rs = st.executeQuery();
            rs.next();
            Doktor tmp = new Doktor();
            tmp.setDoktor_id(rs.getLong("doktor_id"));
            tmp.setDoktor_name(rs.getString("doktor_name"));
            tmp.setDoktor_lastname(rs.getString("doktor_lastname"));
            tmp.setUser_entity(this.getUserdao().find(rs.getLong("user_id")));
            tmp.setKlinik_entity(this.getKlinikdao().detail(rs.getLong("klinik_id")));

            doktor = tmp;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return doktor;
    }

    public void update(Doktor doktor2) {//duzenleme metodu inserte benzer...
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update doktor set doktor_name=?, doktor_lastname=?,user_id=?,klinik_id=? where doktor_id=?" );
            pst.setString(1, doktor2.getDoktor_name());
            pst.setString(2, doktor2.getDoktor_lastname());
            pst.setLong(3, doktor2.getUser_entity().getUser_id());
            pst.setLong(4, doktor2.getKlinik_entity().getKlinik_id());
            pst.setLong(5, doktor2.getDoktor_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Doktor deleteDoktor) {//veri silme...
       try {

            PreparedStatement pst2;
            pst2 = this.getConnection().prepareStatement("delete from doktor where doktor_id=?");
            pst2.setLong(1, deleteDoktor.getDoktor_id());
            pst2.executeUpdate();

            

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    
    
       public void insert(Doktor doktor2) {//veri ekleme metodu..

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into doktor (doktor_name, doktor_lastname, user_id, klinik_id) values (?,?,?,?)");
            pst.setString(1, doktor2.getDoktor_name());
            pst.setString(2, doktor2.getDoktor_lastname());
            pst.setLong(3, doktor2.getUser_entity().getUser_id());
            pst.setLong(4, doktor2.getKlinik_entity().getKlinik_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
       
        public List<Doktor> getKlinikdoktor(Long klinik_id) {//ilişki metodu...ilişki sınıfının metodu..
        List<Doktor> klinikDoktor = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from doktor where klinik_id=" + klinik_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               klinikDoktor.add(this.find(rs.getLong("doktor_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return klinikDoktor;
    }
    
        
    public Doktor getUser_doktor(Long user_id) {
        Doktor doktor=new Doktor();
        try{
            PreparedStatement pst=this.getConnection().prepareStatement("select * from doktor where user_id=" +user_id);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
              
                doktor.setDoktor_id(rs.getLong("doktor_id"));
                doktor.setDoktor_name(rs.getString("doktor_name"));
                doktor.setDoktor_lastname(rs.getString("doktor_lastname"));
                
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return doktor;
    }
    

    public KlinikDAO getKlinikdao() {
        if (this.klinikdao == null) {
            this.klinikdao = new KlinikDAO();
        }
        return klinikdao;
    }

    public void setKlinikdao(KlinikDAO klinikdao) {
        this.klinikdao = klinikdao;
    }

    public UserDao getUserdao() {
        if (this.userdao == null) {
            this.userdao = new UserDao();
        }

        return userdao;

    }

    public MuayeneDao getMuayeneDao() {
        if(this.muayeneDao==null)
            this.muayeneDao=new MuayeneDao();
        return muayeneDao;
    }

    public void setMuayeneDao(MuayeneDao muayeneDao) {
        this.muayeneDao = muayeneDao;
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
