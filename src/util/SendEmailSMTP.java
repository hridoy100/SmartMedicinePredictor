package util;
import com.sun.mail.smtp.SMTPTransport;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmailSMTP {

    // for example, smtp.mailgun.org
    private static final String SMTP_SERVER = "smtp.mailtrap.io";
    private static final String USERNAME = "66f8e9dc600409";
    private static final String PASSWORD = "d387b7607a679b";

    private static String EMAIL_FROM = "raihanul.hridoy100@gmail.com";
    private static String EMAIL_TO = "1505010.smra@ugrad.cse.buet.ac.bd";
    private static String EMAIL_TO_CC = "";

    private static String EMAIL_SUBJECT = "Medicine For Your Health";
    private static String EMAIL_TEXT = "Hello Java Mail \n ABC123";

    public static void sendEmail(String message, String email) {

        EMAIL_TO=email;
        EMAIL_TEXT = message;
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "2525"); // default port 25

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {

            // from
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            // to
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(EMAIL_TO, false));

            // cc
            msg.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(EMAIL_TO_CC, false));

            // subject
            msg.setSubject(EMAIL_SUBJECT);

            // content
            msg.setText(EMAIL_TEXT);

            msg.setSentDate(new Date());

            // Get SMTPTransport
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

            // connect
            t.connect(SMTP_SERVER, USERNAME, PASSWORD);

            // send
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response: " + t.getLastServerResponse());

            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}