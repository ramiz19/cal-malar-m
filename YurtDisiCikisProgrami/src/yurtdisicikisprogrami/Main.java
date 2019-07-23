/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yurtdisicikisprogrami;

/**
 *
 * @author cemr_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        System.out.println("Sabiha gokcen havalimanına hosgeldiniz..");

        String sartlar = "Yurtdısı Cıkıs Kuralları...\n"
                + "Herhani bir siyasi yasagınız bulunmaması gerekiyor\n"
                + "15 TL harc bedelini yatırmanız gerekiyor\n"
                + "gideceğiniz ulkeye vizenizin bulunması gerekiyor..";
        String message = "yurt dısı sartlarından hepsini sağlamanız gerekir..";

        while (true) {

            System.out.println("***********************");
            System.out.println(sartlar);
            System.out.println("***********************");

            Yolcu yolcu = new Yolcu();
            System.out.println("Harc bedeli kontrol ediliyor...");

            Thread.sleep(3000);//programı 3 saniye bekletiyoruz

            if (yolcu.yurtDisiHarcKontrol() == false) {
                System.out.println(message);
                continue;//işlem yanlıssa dongunun en basına gitmek için kullanıyoruz
            }

            System.out.println("Siyasi yasak kontrol ediliyor");

            Thread.sleep(3000);
            if (yolcu.siyasiYaskKontrol() == false) {
                System.out.println(message);
                continue;
            }

            System.out.println("Vize durumu kontrol ediliyor..");
            Thread.sleep(3000);

            if (yolcu.vizeDurumkontrol() == false) {
                System.out.println(message);
                continue;
            }

            System.out.println("işlemleriniz tamam yurt dısına cıkabilirsiniz");

            break;
        }

    }

}
