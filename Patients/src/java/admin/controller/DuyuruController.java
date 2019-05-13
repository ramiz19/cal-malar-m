package admin.controller;

import admin.dao.DuyurularDao;
import entity.Duyurular;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "duyuru")
@SessionScoped
public class DuyuruController implements Serializable {

    DuyurularDao dDao = null;
    Duyurular duyurular = null;
    ArrayList<Duyurular> duyuruList = null;
    ArrayList<Integer> pageList = null;

    public int sayi() {
        return this.getdDao().kayitSay();
    }

    public String createForm() {
        this.duyurular = null;
        return "/admin/duyurular/create?faces-redirect=true";

    }

    public String create() {
        Calendar simdi = Calendar.getInstance();
        
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        
        String sss= sdf.format(simdi.getTime());
        this.duyurular.setTarih(sss);
        
        this.getdDao().create(this.duyurular);
        this.duyuruList = getdDao().List(1);
        return "/admin/duyurular/list?faces-redirect=true";

    }

    public String List(int page) {
        this.duyuruList = this.getdDao().List(page);
        return "/admin/duyurular/list?faces-redirect=true";

    }

    public String updateForm(Duyurular d) {
        this.duyurular = d;

        return "/admin/duyurular/update?faces-redirect=true";

    }

    public String update() {
        this.getdDao().update(this.duyurular);
        this.duyuruList = getdDao().List(1);
        return "/admin/duyurular/list?faces-redirect=true";

    }

    public String delete(int id) {
        this.dDao.delete(id);
        this.duyuruList = getdDao().List(1);
        return "/admin/duyurular/list?faces-redirect=true";

    }

    public ArrayList<Integer> getPageList() {

        this.pageList = new ArrayList();
        int count = getdDao().List().size();
        count = (count - 1) / 10;
        for (int i = 0; i <= count; i++) {
            this.pageList.add(i + 1);
        }
        return pageList;
    }

    public void setPageList(ArrayList<Integer> pageList) {
        this.pageList = pageList;
    }

    public DuyurularDao getdDao() {
        if (this.dDao == null) {
            this.dDao = new DuyurularDao();
        }
        return dDao;
    }

    public void setdDao(DuyurularDao dDao) {
        this.dDao = dDao;
    }

    public Duyurular getDuyurular() {
        if (this.duyurular == null) {
            this.duyurular = new Duyurular();
        }
        return duyurular;
    }

    public void setDuyurular(Duyurular duyurular) {
        this.duyurular = duyurular;
    }

    public ArrayList<Duyurular> getDuyuruList() {
        if (this.duyuruList == null) {
            this.duyuruList = this.getdDao().List();
        }
        return duyuruList;
    }

    public void setDuyuruList(ArrayList<Duyurular> duyuruList) {
        this.duyuruList = duyuruList;
    }

}
