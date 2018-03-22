import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class Email1{
		
		    public static void main(String[] args) {
	  final String username = "SK00483984@Techmahindra.com";  
    final String password = "sree^1234";   
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "BLREXCHMBX001.Techmahindra.com");
    props.put("mail.smtp.port", "25");
    props.put("mail.smtp.ssl.trust", "BLREXCHMBX001.Techmahindra.com");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username,password);
        }
      });
    session.setDebug(true);

try {
 Message message1 = new MimeMessage(session);
	  message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("SR00438113@TechMahindra.com"));  
        message1.setSubject("SSA Notification mail");
          
     StringBuilder sb = new StringBuilder();
   sb.append("<html><body><p>Dear User,<br></p> <p>The Requested SR-SR0001 is successfully completed and find the below details.</p> <style>table, td, th { border: 1px solid black; }table {border-collapse: collapse;} </style><table height: 90px;  width=\"100%\" cellspacing = \"10\"> <tr><th bgcolor=\"#ff6666\">S.no</th><th bgcolor=\"#ff6666\">Remarks</th><th bgcolor=\"#ff6666\">Url</th></tr> <tr><td>1</td> <td>Jira</td><td>http://INBASDPC05678:8899/{ProjectName}</td> </tr><tr> <td>2</td> <td>SCM Repository URL</td><td>http://admin@10.53.67.52:7990/scm/os/{projectname}.git</td> </tr> <tr> <td>3</td> <td>Pipeline in Jenkins</td><td>http://bsdpcs2964481:9093/jenkins/job/{pipelinename}</td></tr> </table><pre> This is a SSA  generated mail. Please do not reply to this mail.<br> For any queries please raise a request. <br>Thanks,<br>SSA DevOps Team </pre> </body> </html>");
   Message msg = message1;
    msg.setContent(sb.toString(), "text/html");
    
    
/*String filename = "C:/Users/sk00483984/Desktop/Document in SSA Details Design Document v0.3.docx";
    DataSource source = new FileDataSource(filename);
    message1.setDataHandler(new DataHandler(source));
    message1.setFileName(filename);*/
    
          Transport.send(message1);   
          }catch (Exception ex) {
          	ex.printStackTrace();
          }
          }
         }




