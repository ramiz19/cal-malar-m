package entity;


import java.util.Date;


public class Duyurular {
    
    private int id;
    private String duyuru;
    private String tarih;
    

    public Duyurular() {
        this.id=0;
        this.duyuru="";
        this.tarih="bugun";
    }

       
    
    public Duyurular(int id, String duyuru, String tarih) {
        this.id = id;
        this.duyuru = duyuru;
        this.tarih = tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuyuru() {
        return duyuru;
    }

    public void setDuyuru(String duyuru) {
        this.duyuru = duyuru;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
    
    
    
    
}
