package fronted.controller;

import admin.dao.DuyurularDao;
import admin.dao.KlinikDAO;
import entity.Duyurular;
import entity.Poliklinik;
import entity.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "frontend")
@SessionScoped
public class FrontendController implements Serializable {

    DuyurularDao dDao = null;
    ArrayList<Duyurular> duyuruList = null;

    private KlinikDAO klinikDao = null;
    private List<Poliklinik> klinikList;

    public String randevual() {

        return "/frontend/randevual?faces-redirect=true";
    }

    public boolean isLogin() {

        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("user", null);

        if (user == null) {
            return false;
        } else {
            return true;
        }

    }

    public String Giris() {
    
        
        return "/login?faces-redirect=true";
    }

    public String goklinik() {

        return "/frontend/index?faces-redirect=true";
    }

    public String profile() {
        
        
        return "/frontend/profile?faces-redirect=true";
    }

    public String create() {

        return "/frontend/index?faces-redirect=true";
    }

    public String main() {

        return "http://localhost:8080/Patients/";
    }

    public String iletisim() {
        return "/frontend/static/iletisim?faces-redirect=true";
    }

    public String sorular() {
        return "/frontend/static/sorular?faces-redirect=true";
    }

    public String hakkimizda() {

        return "/frontend/static/hakkimizda?faces-redirect=true";
    }

    public String bolumler() {

        return "/frontend/static/bolumler?faces-redirect=true";
    }

    public List<Poliklinik> getKlinikList() {
        if (this.klinikList == null) {
            this.klinikList = new ArrayList<>();
        }
        this.klinikList = this.getKlinikDao().findALL();
        return klinikList;
    }

    public void setKlinikList(List<Poliklinik> klinikList) {
        this.klinikList = klinikList;
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

    public DuyurularDao getdDao() {
        if (this.dDao == null) {
            this.dDao = new DuyurularDao();
        }

        return dDao;
    }

    public void setdDao(DuyurularDao dDao) {
        this.dDao = dDao;
    }

    public ArrayList<Duyurular> getDuyuruList() {
        if (this.duyuruList == null) {
            this.duyuruList = new ArrayList();
        }
        this.duyuruList = this.getdDao().frontList();
        return this.duyuruList;
    }

    public void setDuyuruList(ArrayList<Duyurular> duyuruList) {
        this.duyuruList = duyuruList;
    }

}
