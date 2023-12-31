package edu.training.mail;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {
    public static void main(String[] args) {
        System.out.println("Outlook Email Start");
        String smtpHostServer = "smtp.office365.com";
        final String emailID = "priya.jp0210@outlook.com";
        final String password = "Welcome@123";
        String toEmail = "imsathyapriya@gmail.com";
        String subject = "Outlook Email Testing Subject";
        String messageBody = "I love Benson";

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHostServer);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailID, password);
            }
        });

        sendEmail(session, emailID, subject, messageBody, toEmail);
    }

    public static void sendEmail(Session session, String fromEmail, String subject, String body, String toEmail) {
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            msg.setSubject(subject, "UTF-8");
            msg.setSentDate(new Date());
            msg.setText(body, "UTF-8");

            // Add DKIM and SPF headers here if you have configured them

            System.out.println("Message is ready");
            Transport.send(msg);
            System.out.println("Email Sent Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
