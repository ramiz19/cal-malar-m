/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzayoyunu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author cemr_
 */

class Ates{
    private int x;
    private int y;

    public Ates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}

public class Oyun extends JPanel implements KeyListener,ActionListener{
    
    Timer timer = new Timer(1, this);
    private int gecen_sure = 0;
    private int harcanan_ates = 0;
    
    private BufferedImage image;
    
    private ArrayList<Ates> atesler = new ArrayList<>();
    
    private int atesdirY = 1;//ateslerin hareketi
    private int topX = 0;//top saga sola hareket ettirir
    
    private int topdirX = 12;//topx e eklenecek
    
    private int uzayGemisiX = 0;//0 dan baslayacak
    private int dirUzaayX = 20;//gemiyi 20 birim saga sola kaydır
    
    public boolean kontrolEt(){
        for (Ates ates : atesler) {
            if (new Rectangle(ates.getX(),ates.getY(),5,10).intersects(new Rectangle(topX,0,20,20))) {
                return true;
            }
        }
        
        return false;
    }

    public Oyun() {
        try {
            image = ImageIO.read(new FileImageInputStream(new File("uzaygemisi.jpeg")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setBackground(Color.black);
        
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        gecen_sure +=5;
        
        g.setColor(Color.red);
        g.fillOval(topX, 0, 20, 20);//top cizme
        
        g.drawImage(image, uzayGemisiX, 490, image.getWidth()/10,image.getHeight()/10,this);//resimi ayarlama methodu
        
        for (Ates ates : atesler) {
            if (ates.getY() < 0) {
                atesler.remove(ates);
            }
        }
        
        g.setColor(Color.blue);
        
        for (Ates ates : atesler) {
            g.fillRect(ates.getX(), ates.getY(), 5, 10);
        }
        
        if (kontrolEt()) {
            timer.stop();
            
            String message = "Kazandınız \n"+
                             "Harcanan Ates = \n"+harcanan_ates+
                    "Gecen Sure = "+gecen_sure/1000.0+" saniye";
            
            JOptionPane.showMessageDialog(this, message);
            
            System.exit(0);
        }
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
       
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
         //uzay gemisini saga sola hareket ettirmek ve kontrol etmek
        int c = e.getKeyCode();
        
        if (c == KeyEvent.VK_LEFT) {
            if (uzayGemisiX <= 0) {
                uzayGemisiX = 0;
            }
            else{
                uzayGemisiX -= dirUzaayX;
            }
        }
        else if (c == KeyEvent.VK_RIGHT) {
            if (uzayGemisiX >= 760) {
                uzayGemisiX = 760;
            }
            else{
                uzayGemisiX +=dirUzaayX;
            }
        }
        else if (c == KeyEvent.VK_W) {//ates olusturma methodu
            atesler.add(new Ates(uzayGemisiX+15, 470));
            
            harcanan_ates++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (Ates ates : atesler) {
            ates.setY(ates.getY() - atesdirY);
        }
        
        //topun hareketi ve controlu
        topX +=topdirX;
        
        if (topX >= 775) {
            topdirX = -topdirX;
        }
        if (topX <= 0) {
            topdirX = -topdirX;
        }
        
        repaint();
    }

  
    
}
