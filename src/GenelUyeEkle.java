import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GenelUyeEkle {
    private static final String GENEL_KULLANICILAR_BASLIK = "#GENEL UYELER";
    private static final String DOSYA = "Kullanicilar.txt";

    public static void ejecutar() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Genel uyenin adini girin:");
    String nombre = scanner.nextLine();

    System.out.println("Genel uyenin soyadini girin:");
    String apellido = scanner.nextLine();

    System.out.println("Genel uyenin email girin:");
    String correo = scanner.nextLine();
        try {
            File dosya = new File(DOSYA);
            Scanner scannerDosya = new Scanner(dosya);

            ArrayList<String> satiriler = new ArrayList<String>();
            boolean ekleolan = false;
            while (scannerDosya.hasNextLine()) {
                String satiri = scannerDosya.nextLine();
                if (satiri.contains(GENEL_KULLANICILAR_BASLIK)) {
                    satiriler.add(satiri);
                    satiriler.add(nombre + " " + apellido + " " + correo);
                    ekleolan = true;
                } else {
                    satiriler.add(satiri);
                }
            }

            if (!ekleolan) {
                satiriler.add("");
                satiriler.add(GENEL_KULLANICILAR_BASLIK);
                satiriler.add(nombre + " " + apellido + " " + correo);
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
