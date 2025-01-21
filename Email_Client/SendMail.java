import java.util.ArrayList; 
import java.util.Properties; 
import javax.mail.Message; 
import javax.mail.MessagingException; 
import javax.mail.PasswordAuthentication; 
import javax.mail.SendFailedException; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 
 
class SendMail { 
 
  boolean send(String email,String subject,String content) { 
      //set user name &  password to login 
      //Here use app password 
      final String username = "Enter Your e-mail here"; 
        final String password = "Enter App password here"; 
 
        Properties prp = new Properties(); 
        prp.put("mail.smtp.host", "smtp.gmail.com"); 
        prp.put("mail.smtp.port", "465"); 
        prp.put("mail.smtp.auth", "true"); 
        prp.put("mail.smtp.socketFactory.port", "465"); 
        prp.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
         
        Session session = Session.getInstance(prp, 
                new javax.mail.Authenticator() { 
                    protected PasswordAuthentication getPasswordAuthentication() { 
                        return new PasswordAuthentication(username, password); 
                    } 
                }); 
        try { 
            Message message = new MimeMessage(session); 
            message.setFrom(new InternetAddress(username)); 
            message.setRecipients( 
                    Message.RecipientType.TO, 
                    InternetAddress.parse(email) 
            ); 
            message.setSubject(subject); 
            message.setText(content); 
 
            Transport.send(message); 
            System.out.println("Sent"); 
 
        }catch (SendFailedException e1) { 
          e1.printStackTrace(); 
        } 
        catch (MessagingException e) { 
            e.printStackTrace(); 
        } 
        return true; 
  } 
  //save sent mail to an ArryList to store 
  void saveDraft(ArrayList<E_mail> sentemails,E_mail email) { 
    sentemails.add(email); 
  } 
}