import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ElitUyeEkle {

    private static final String DOSYA = "Kullanicilar.txt";
    private static final String ELIT_KULLANICILAR_BASLIK = "#ELYT UYELER";

    public static void ejecutar() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Elit uyenin adini girin:");
    String adi = scanner.nextLine();

    System.out.println("Elit uyenin soyadini girin:");
    String soyadi = scanner.nextLine();

    System.out.println("Elit uyenin e-mail girin:");
    String email = scanner.nextLine();
        try {
            File dosya = new File(DOSYA);
            Scanner scannerDosya = new Scanner(dosya);

            ArrayList<String> satiriler = new ArrayList<String>();
            boolean eklenolan = false;
            while (scannerDosya.hasNextLine()) {
                String satiri = scannerDosya.nextLine();
                if (satiri.contains(ELIT_KULLANICILAR_BASLIK)) {
                    satiriler.add(satiri);
                    satiriler.add(adi + " " + soyadi + " " + email);
                    eklenolan = true;
                } else {
                    satiriler.add(satiri);
                }
            }

            if (!eklenolan) {
                satiriler.add(ELIT_KULLANICILAR_BASLIK);
                satiriler.add(adi + " " + soyadi + " " + email);
            }

            FileWriter fw = new FileWriter(DOSYA);
            PrintWriter pw = new PrintWriter(fw);

            for (String satiri : satiriler) {
                pw.println(satiri);
            }

            pw.close();
            System.out.println("Genel uye basariyla dosyaya eklendi.");
        } catch (IOException e) {
            System.out.println("Dosyaya genel uye eklenirken hata olustu.");
        }
    }
}
