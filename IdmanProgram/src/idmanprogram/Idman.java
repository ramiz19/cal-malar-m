/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanprogram;

/**
 *
 * @author cemr_
 */
public class Idman {
    private int barfiks_sayi;
    private int mekik_sayi;
    private int sinav_sayi;

    public Idman() {
    }

    public Idman(int barfiks_sayi, int mekik_sayi, int sinav_sayi) {
        this.barfiks_sayi = barfiks_sayi;
        this.mekik_sayi = mekik_sayi;
        this.sinav_sayi = sinav_sayi;
    }

    public int getBarfiks_sayi() {
        return barfiks_sayi;
    }

    public void setBarfiks_sayi(int barfiks_sayi) {
        this.barfiks_sayi = barfiks_sayi;
    }

    public int getMekik_sayi() {
        return mekik_sayi;
    }

    public void setMekik_sayi(int mekik_sayi) {
        this.mekik_sayi = mekik_sayi;
    }

    public int getSinav_sayi() {
        return sinav_sayi;
    }

    public void setSinav_sayi(int sinav_sayi) {
        this.sinav_sayi = sinav_sayi;
    }
    
    public void hareketYap(String hareket_turu, int sayi){
        if (hareket_turu.equals("mekik")) {
            mekikCek(sayi);
        }else if (hareket_turu.equals("sinav")) {
            sinavCek(sayi);
        }else if (hareket_turu.equals("barfiks")) {
            barfiksCek(sayi);
        }else{
            System.out.println("gecersiz hareket");
        }
    }
     public void mekikCek(int sayi){
        if (mekik_sayi == 0) {
            System.out.println("yapacak mekik kalmadı");
        }
        if (mekik_sayi-sayi < 0) {
            System.out.println("tebrikler ");
            mekik_sayi = 0;
            System.out.println("kalan mekik = "+mekik_sayi);
        }else{
            mekik_sayi -=sayi;
            System.out.println("kalan mekik sayısı = "+mekik_sayi);
        }
    }
    public void sinavCek(int sayi){
        if (sinav_sayi == 0) {
            System.out.println("yapacak sınav kalmadı");
        }
        if (sinav_sayi-sayi < 0) {
            System.out.println("tebrikler ");
            sinav_sayi = 0;
            System.out.println("kalan sınav = "+sinav_sayi);
        }else{
            sinav_sayi -=sayi;
            System.out.println("kalan sınav sayısı = "+sinav_sayi);
        }
    }
     public void barfiksCek(int sayi){
        if (barfiks_sayi == 0) {
            System.out.println("yapacak barfiks kalmadı");
        }
        if (barfiks_sayi-sayi < 0) {
            System.out.println("tebrikler ");
            barfiks_sayi = 0;
            System.out.println("kalan barfiks = "+barfiks_sayi);
        }else{
            barfiks_sayi -=sayi;
            System.out.println("kalan barfiks sayısı = "+barfiks_sayi);
        }
    }
     public boolean idmanBittiMi(){
         return (barfiks_sayi == 0)&&(mekik_sayi == 0)&&(sinav_sayi == 0);
     }
}
