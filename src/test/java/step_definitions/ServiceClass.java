package step_definitions;

import io.cucumber.java.Scenario;
import pages.BaseClass;
import pages.DriverFactory;

public class ServiceClass extends BaseClass {
    Scenario scenario = null;

    @io.cucumber.java.Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
    }
    @io.cucumber.java.Before
    public void initiateBrowser() throws Exception {
        //initializeBrowser();
        DriverFactory.initialiseBrowser();
    }
    @io.cucumber.java.After
    public void after() throws Exception {
        closeBrowser(scenario);
        System.out.println("after step--"+publicURL);
        scenario.attach(publicURL,"text/plain","Browser Stack video Link");
    }

//    @io.cucumber.java.After
//    public void sendEmail(){
//        Properties properties = new Properties();
////        properties.put("mail.smtp.host", "smtp.gmail.com"); // Change to your SMTP server
////        properties.put("mail.smtp.socketFactory.port", "465");
////        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
////        properties.put("mail.smtp.auth", "true");
////        properties.put("mail.smtp.port", "465"); // Change to your SMTP port
//
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//
//        // Step 3: Authenticate with the SMTP server
//        Authenticator authenticator = new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("kannansasi1997@gmail.com", "Raeskasa1997@"); // Change to your email credentials
//            }
//        };
//
//        // Step 4: Create a session
//        Session session = Session.getInstance(properties, authenticator);
//
//        try {
//            // Step 5: Create a MimeMessage
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("kannansasi1997@gmail.com")); // Change to your email address
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sasikumar.re97@gmail.com")); // Change to recipient's email address
//            message.setSubject("Cucumber Report");
//
//            // Step 6: Create the message body
//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText("Please find attached cucumber report.");
//
//            // Step 7: Attach the HTML report
//            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
//            attachmentBodyPart.attachFile("target/cucumber-reports/cucumber-html-reports/overview-features.html");
//
//            // Step 8: Create multipart
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//            multipart.addBodyPart(attachmentBodyPart);
//
//            // Step 9: Set multipart as content of message
//            message.setContent(multipart);
//
//            // Step 10: Send the message
//            Transport.send(message);
//
//            System.out.println("Email sent successfully.");
//
//        } catch (MessagingException | IOException e) {
//            e.printStackTrace();
//        }

}
