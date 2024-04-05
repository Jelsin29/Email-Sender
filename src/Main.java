import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {

 public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int option = 0;
    
    do {
      System.out.println("Menu:");
      System.out.println("1- Elit uye ekleme");
      System.out.println("2- Genel uye ekleme");
      System.out.println("3- Mail Gonderme");
      System.out.println("0- Disari Cikmak");
      System.out.print("Bir secenek girin: ");
      option = sc.nextInt();
      
      switch (option) {
        case 1:
          ElitUyeEkle ElitUye = new ElitUyeEkle();

          ElitUye.ejecutar();
          break;
        case 2:
          GenelUyeEkle GenelUye = new GenelUyeEkle();
          GenelUye.ejecutar();
          break;
        case 3:
            MailleriGonder gonder = new MailleriGonder();
            gonder.ejecutar();
            break;
        case 0:
          System.out.println("Programdan ayriliyor...");
          break;
        default:
          System.out.println("Gecersiz secenek, tekrar amac.");
      }
      
    } while (option != 0);
    
    sc.close();
  }

public static String ElitPostaAlmak() {
    String sonuc = "";
    boolean bayrak = false;

    try {
        Scanner scanner = new Scanner(new File("kullanicilar.txt"));
        while (scanner.hasNextLine()) {
            String elit_satiri = scanner.nextLine();
            if (elit_satiri.equals("#GENEL UYELER")) {
                bayrak = false;
            } else if (elit_satiri.equals("#ELYT UYELER")) {
                bayrak = true;
            } else if (bayrak) {
                String[] elit_bilgiler = elit_satiri.split(" ");
                sonuc += elit_bilgiler[elit_bilgiler.length - 1] + ";";
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("Kullanicilar.txt dosyasi mevcut degil.");
    }

    return sonuc;
}

public static String GenelPostaAlmak() {
    String sonuc = "";

    try {
        Scanner scanner = new Scanner(new File("Kullanicilar.txt"));
        boolean bayrak = false;
        while (scanner.hasNextLine()) {
            String genel_satiri = scanner.nextLine();
            if (genel_satiri.equals("#ELYT UYELER")) {
                bayrak = false;
            } else if (genel_satiri.equals("#GENEL UYELER")) {
                bayrak = true;
            } else if (bayrak) {
                String[] genel_bilgiler = genel_satiri.split(" ");
                sonuc += genel_bilgiler[genel_bilgiler.length - 1] + ";";
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("Kullanicilar.txt dosyasi mevcut degil.");
    }

    return sonuc;
}


}