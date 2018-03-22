

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendAttachmentInEmail {
   public static void main(String[] args) {
      // Recipient's email ID needs to be mentioned.
      String to = "lr00476220@TechMahindra.com";

      // Sender's email ID needs to be mentioned
      String from = "SK00483984@Techmahindra.com";

      final String username = "SK00483984@Techmahindra.com";//change accordingly
      final String password = "sree^1234";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "BLREXCHMBX001.Techmahindra.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "25");
      props.put("mail.smtp.ssl.trust", "BLREXCHMBX001.Techmahindra.com");
      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject("SSA Notification mail");

        
         StringBuilder sb = new StringBuilder();
          sb.append("<html><body><p>Dear User,<br></p> <p>The Requested SR-SR0001 is successfully completed and find the below details.</p> <style>table, td, th { border: 1px solid black; }table {border-collapse: collapse;} </style><table height: 50px;  width=\"50%\" cellspacing = \"10\"> <tr><th bgcolor=\"#ff6666\">S.no</th><th bgcolor=\"#ff6666\">Remarks</th><th bgcolor=\"#ff6666\">Url</th></tr> <tr><td>1</td> <td>Jira</td><td>http://INBASDPC05678:8899/{ProjectName}</td> </tr><tr> <td>2</td> <td>SCM Repository URL</td><td>http://admin@10.53.67.52:7990/scm/os/{projectname}.git</td> </tr> <tr> <td>3</td> <td>Pipeline in Jenkins</td><td>http://bsdpcs2964481:9093/jenkins/job/{pipelinename}</td></tr> </table> </p1><pre> This is a SSA  generated mail. Please do not reply to this mail. For any queries please raise a request. Thanks,SSA DevOps Team </pre> </body> </html>");
         Message msg = message;
       msg.setContent(sb.toString(), "text/html");
   
     
         
     
		

         // Part two is attachment
         MimeBodyPart messageBodyPart = new MimeBodyPart();
         String filename = "C:/Users/sk00483984/Desktop/Document in SSA Details Design Document v0.3.docx";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         Multipart multipart = null;
		multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);
         
       
         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
  
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}