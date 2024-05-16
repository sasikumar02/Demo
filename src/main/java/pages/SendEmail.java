package pages;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail extends BaseClass{

    public static void sendEmailUsingJava(){
        System.out.println("inside send email class");
        String message = "received email from sender";
        String subject = "Java Email";
        String to = "sasikumar.re97@gmail.com";
        String from = "kannansasi1997@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session=Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("kannansasi1997@gmail.com","znvz hjnf pfro pnlx");
            }
        });

        session.setDebug(true);

        MimeMessage mimeMessage=new MimeMessage(session);
        try{
            mimeMessage.setFrom(from);
            mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);
            Transport.send(mimeMessage);
            System.out.println("Emil sent successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
