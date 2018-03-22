
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email{
public static void main(String[] args) {
    final String username = "SK00483984@Techmahindra.com";  
    final String password = "sree^1234";  
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "BLREXCHMBX001.Techmahindra.com");
    props.put("mail.smtp.port", "25");
    props.put("mail.smtp.ssl.trust", "BLREXCHMBX001.Techmahindra.com");

	
    Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username,password);
        }
      });
    session.setDebug(true);

    try {
    	   Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("bm00476212@TechMahindra.com"));  
        message.setSubject("SSA Notification mail");
    
     String text= ("Dear User,\n"+"The Requested SR-SR0001 is successfully completed and find the below details.\n"+"This is a SSA  generated mail. Please do not reply to this mail. \n"+"For any queries please raise a request.\n"+"Thanks,\n"+"SSA DevOps Team.");

	 
     message.setText(text);
     
     Transport.send(message);
      
        System.out.println("Done");

    } 
    catch (MessagingException e) {
        throw new RuntimeException(e);
    }
}
}

