/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramazan.pidesikuyruk;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author cemr_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //fırında 1 dahil 10 kadar pide alacak.
        
        System.out.println("Ramazan pidesi uygulaması");
        
        Random random = new Random();
        
        Queue<String> pide = new LinkedList<>();
        
        pide.offer("Murat");
        pide.offer("remzi");
        pide.offer("mustafa");
        pide.offer("ayse");
        pide.offer("merve");
        pide.offer("okan");
        pide.offer("cemre");
        pide.offer("oğuz");
        pide.offer("gizem");
        pide.offer("ezgi");
        pide.offer("ali");
        
        int pide_sayisi = 1 + random.nextInt(10);
        System.out.println("pideler cıkıyor....");
        System.out.println("Cıkan pide sayısı : "+pide_sayisi);
        
        Thread.sleep(3000);
        
        while (pide_sayisi != 0) {            
            System.out.println(pide.poll()+" pideyi aldı...");
            
            pide_sayisi--;
            Thread.sleep(1000);
        }
        
        System.out.println("Pide kalmadı...");
        
    }
    
}
