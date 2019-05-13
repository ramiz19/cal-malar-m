/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import entity.Yetkilendirme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cemr_
 */
public class YetkiDao extends Dao {

    private RoleDao roleDao;

    public List<Yetkilendirme> findAll() {
        List<Yetkilendirme> yetkiList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from yetkilendirme");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Yetkilendirme tmp = new Yetkilendirme();
                tmp.setId(rs.getLong("id"));
                tmp.setModule(rs.getString("module"));
                tmp.setC(rs.getBoolean("C"));
                tmp.setR(rs.getBoolean("R"));
                tmp.setU(rs.getBoolean("U"));
                tmp.setD(rs.getBoolean("D"));
                tmp.setDel(rs.getBoolean("Del"));

                tmp.setRole(this.getRoleDao().find(rs.getLong("role_id")));

                yetkiList.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return yetkiList;
    }

    public void insert(Yetkilendirme yetki) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into yetkilendirme ( module, C, R,U,D,Del,role_id) values (?,?,?,?,?,?,?)");

            pst.setString(1, yetki.getModule());
            pst.setBoolean(2, yetki.isC());
            pst.setBoolean(3, yetki.isR());
            pst.setBoolean(4, yetki.isU());
            pst.setBoolean(5, yetki.isD());
            pst.setBoolean(6, yetki.isDel());
            pst.setLong(7, yetki.getRole().getRole_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Yetkilendirme yetki) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Yetkilendirme deleteYetki) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RoleDao getRoleDao() {
        if (this.roleDao == null) {
            this.roleDao = new RoleDao();
        }
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

}
