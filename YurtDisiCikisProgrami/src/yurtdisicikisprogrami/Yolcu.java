/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurtdisicikisprogrami;

import java.util.Scanner;

/**
 *
 * @author cemr_
 */
public class Yolcu implements YurtDisiKurallari{
    
    private int harc;
    private boolean siyaisiYasak;
    private boolean vizeDurum;

    public Yolcu() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Yatırdığınız harc bedeli : ");
        
        this.harc = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Herhangi bir siyasi yasağınız bulunuyor mu (evet yada hayır cevabını verin) : ");
        
        String cevap = scanner.nextLine();
        
        if (cevap.equals("evet")) {
            this.siyaisiYasak = true;
        }else{
            this.siyaisiYasak = false;
        }
        
        System.out.print("vizeniz bulunuyor mu ? (evet veya hayır) : ");
         
        String cevap2 = scanner.nextLine();
        if (cevap2.equals("evet")) {
            this.vizeDurum = true;
        }else{
            this.vizeDurum = false;
        }
                
    }

    @Override
    public boolean yurtDisiHarcKontrol() {
        if (this.harc < 15) {
            System.out.println("harcınız yetersiz...");
            return false;
        }else{
            System.out.println("harcınız yeterli");
            return true;
        }
    }

    @Override
    public boolean siyasiYaskKontrol() {
        if (this.siyaisiYasak == true) {
            System.out.println("Siyasi yasağınız bulunuyor.. Yurtdısına cıkamazsınız..");
            return false;
        }else{
            System.out.println("siyasi yasağınız bulunmuyor...yurtdısına cıkabilirsiniz..");
            return true;
        }
    }

    @Override
    public boolean vizeDurumkontrol() {
         if (this.vizeDurum == false) {
            System.out.println("Vizeniz bulunmuyor.. Yurtdısına cıkamazsınız..");
            return false;
        }else{
            System.out.println("Vize bulunuyor...yurtdısına cıkabilirsiniz..");
            return true;
        }
    }

    public int getHarc() {
        return harc;
    }

    public void setHarc(int harc) {
        this.harc = harc;
    }

    public boolean isSiyaisiYasak() {
        return siyaisiYasak;
    }

    public void setSiyaisiYasak(boolean siyaisiYasak) {
        this.siyaisiYasak = siyaisiYasak;
    }

    public boolean isVizeDurum() {
        return vizeDurum;
    }

    public void setVizeDurum(boolean vizeDurum) {
        this.vizeDurum = vizeDurum;
    }
    
    
    
    
    
    
}
