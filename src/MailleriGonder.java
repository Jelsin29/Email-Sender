import java.util.Properties;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

public class MailleriGonder {

    public static void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("E-mail kime gondermek istediginiz secin:");
        System.out.println("1- Elit uyelere mail");
        System.out.println("2- Genel uyelere mail");
        System.out.println("3- Tum uyelere mail");

        int opcion = scanner.nextInt();
        scanner.nextLine();


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        final String username = " ";//Here you should put your email.
        final String password = "";//Here you should put the token


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });


        switch (opcion) {
            case 1:
                String destinatarios = Main.ElitPostaAlmak();
                String[] destinatariosArray = destinatarios.split(";");
                for (String destinatario : destinatariosArray) {
                    try {
                        // Kodla yapabileceğimin en iyisi bu, böylece e-postaları doğru şekilde gönderebildim çünkü derlerken bana her zaman bir tür hata verdi.
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(username));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                        System.out.print("E-mail konusunu girin: ");
                        String subject = scanner.nextLine();
                        message.setSubject(subject);
                        System.out.print("E-mail icerigini girin: ");
                        String content = scanner.nextLine();
                        message.setText(content);


                        Transport.send(message);

                        System.out.println("e-mail basariyla gonderildi.");
                    } catch (AddressException e) {
                        throw new RuntimeException(e);
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                }

                break;
            case 2:
                String destinatarios1 = Main.GenelPostaAlmak();
                String[] destinatarios1Array = destinatarios1.split(";");
                for (String destinatario : destinatarios1Array) {
                    try {

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(username));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                        System.out.print("E-mail konusunu girin: ");
                        String subject = scanner.nextLine();
                        message.setSubject(subject);
                        System.out.print("E-mail icerigini girin: ");
                        String content = scanner.nextLine();
                        message.setText(content);


                        Transport.send(message);

                        System.out.println("e-mail basariyla gonderildi.");
                    } catch (AddressException e) {
                        throw new RuntimeException(e);
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                }

                break;
            case 3:

                String destinatarios2 = Main.ElitPostaAlmak();
                String[] destinatarios2Array = destinatarios2.split(";");
                for (String destinatario : destinatarios2Array) {
                    try {

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(username));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                        System.out.print("E-mail konusunu girin: ");
                        String subject = scanner.nextLine();
                        message.setSubject(subject);
                        System.out.print("E-mail icerigini girin: ");
                        String content = scanner.nextLine();
                        message.setText(content);


                        Transport.send(message);

                        System.out.println("e-mail basariyla gonderildi.");
                    } catch (AddressException e) {
                        throw new RuntimeException(e);
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                }

                String destinatarios3 = Main.GenelPostaAlmak();
                String[] destinatarios3Array = destinatarios3.split(";");
                for (String destinatario : destinatarios3Array) {
                    try {

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(username));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                        System.out.print("E-mail konusunu girin: ");
                        String subject = scanner.nextLine();
                        message.setSubject(subject);
                        System.out.print("E-mail icerigini girin: ");
                        String content = scanner.nextLine();
                        message.setText(content);


                        Transport.send(message);

                        System.out.println("e-mail basariyla gonderildi.");
                    } catch (AddressException e) {
                        throw new RuntimeException(e);
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            default:
                System.out.println("Gecersiz secenek.");
        }
    }

}


