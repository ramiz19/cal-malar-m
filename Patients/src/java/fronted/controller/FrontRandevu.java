/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fronted.controller;

import entity.Hasta;
import entity.Randevu;
import entity.User;
import fronted.dao.HastaDao;
import fronted.dao.RandevuDao;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author makgn
 */
@Named(value = "frontRandevu")
@SessionScoped
public class FrontRandevu implements Serializable {
    
    private Randevu randevu;
    private RandevuDao randevuDao;
    private HastaDao hDao;
    
    
    public String create(){
    
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().getOrDefault("user", null);

        Hasta h= new Hasta();
        
        h=this.gethDao().detail(user.getUser_id());
        
        
        this.getRandevu().setHasta_entity(h);
        
        this.getRandevuDao().insert(this.randevu);
        
        
        return "/frontend/index?faces-redirect=true";
    }

    //this.getSessionDao().getPerm(current.getRole_entity(), module, process);

    public HastaDao gethDao() {
        if(this.hDao==null)
            this.hDao=new HastaDao();
        return hDao;
    }

    public void sethDao(HastaDao hDao) {
        this.hDao = hDao;
    }
    
    
    
    
    public Randevu getRandevu() {
        if(this.randevu==null)
            this.randevu=new Randevu();
        return randevu;
    }

    public void setRandevu(Randevu randevu) {
        this.randevu = randevu;
    }

    public RandevuDao getRandevuDao() {
        if(this.randevuDao==null)
            this.randevuDao=new RandevuDao();
        return randevuDao;
    }

    public void setRandevuDao(RandevuDao randevuDao) {
        this.randevuDao = randevuDao;
    }
    
    
    
    
    
    
    
}
