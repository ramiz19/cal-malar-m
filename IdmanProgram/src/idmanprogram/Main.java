/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanprogram;

import java.util.Scanner;

/**
 *
 * @author cemr_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("idman programına hoşgeldiniz...");
        
        String idmanlar = "Gecerli hareketler..\n"
                + "mekik\n"
                + "barfiks\n"
                + "sınav\n"
                + "cıkıs için q ya bas";
        System.out.println(idmanlar);
        
        System.out.println("Bir idman oluşturun...");
        
        System.out.print("sınav sayısı oluştur = ");
        int sinav = scanner.nextInt();
        
        System.out.print("mekik sayısı oluştur = ");
        int mekik = scanner.nextInt();
        
        System.out.print("barfiks sayısı oluştur = ");
        int barfiks = scanner.nextInt();
        scanner.nextLine();
        
        Idman idman = new Idman(barfiks, mekik, sinav);
        
        System.out.println("idmanınız başlıyor..");
        
        while (idman.idmanBittiMi()==false) {            
            
            System.out.println("hareket turu (sınav, mekik, barfiks)");
            
            String tur = scanner.nextLine();
            
            System.out.println("Bu hareketten kac tane yapacaksınız = ");
            int sayi = scanner.nextInt();
            scanner.nextLine();
            
            idman.hareketYap(tur, sayi);
     
        }
        System.out.println("idmanınız basarıyla sonlandı..");
    }
    
}
