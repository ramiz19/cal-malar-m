/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzayoyunu;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author cemr_
 */
public class OyunEkrani extends JFrame{

    public OyunEkrani(String title) throws HeadlessException {
          super(title);
    }
    
    public static void main(String[] args) {
        OyunEkrani ekrani = new OyunEkrani("Uzay Oyunu");
        
        ekrani.setResizable(false);
        ekrani.setFocusable(false);///jpanele odaklanmak için bu iki özellik false yapıldı
        
        ekrani.setSize(800, 600);
        
        ekrani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Oyun oyun = new Oyun();
        ////////////klavye işlemleri için
        oyun.requestFocus();
        
        oyun.addKeyListener(oyun);//klavye işlemlerini tanıma
        oyun.setFocusable(true);//odağı jpanele veriyoruz
        oyun.setFocusTraversalKeysEnabled(false);//jpanelde klavye işlemlerini anlamak için gerekli olan bir metot
        
        ekrani.add(oyun);//jframe , jpaneli ekliyoruz
        
        ekrani.setVisible(true);
    }
}
