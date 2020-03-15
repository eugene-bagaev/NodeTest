package bot.service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

    private static MailService mail_instance = null;

    private Properties props;

    private String username     = "gta5rp.bot@gmail.com";
    private String password     = "Gp13kost";

    private MailService(String username, String password) {
        this.username = username;
        this.password = password;

        initProperties();
    }

    private MailService() {
        initProperties();
    }

    public static MailService getInstance() {
        if (mail_instance == null) {
            return new MailService();
        }
        return mail_instance;
    }

    public void send(String subject, String text, String fromEmail, String toEmail){

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        username,
                        password
                );
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void initProperties() {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

}