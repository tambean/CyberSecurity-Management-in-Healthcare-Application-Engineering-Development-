/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author orange
 */
public class SendMails {
    
    private String userName;
    private String password;
    private String sendingHost;
    private int sendingPort;
    private String from;
    private String to;
    private String subject;
    private String text;
    public String mailId;

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
    
    public void setAccountDetails(){
 
        this.userName="sheril.aed.fall15";
        String id  = userName+"@gmail.com";
        setMailId(id);
        this.password="northeasternfall15";
 
    }
    
     public void sendGmail(String from, String to, String subject, String text){
 
        this.from=from;
        this.to=to;
        this.subject=subject;
        this.text=text;
 
        this.sendingHost="smtp.gmail.com";
        this.sendingPort=465;
 
        Properties props = new Properties();
 
        props.put("mail.smtp.host", this.sendingHost);
        props.put("mail.smtp.port", String.valueOf(this.sendingPort));
        props.put("mail.smtp.user", this.userName);
        props.put("mail.smtp.password", this.password);
 
        props.put("mail.smtp.auth", "true");
 
         Session session1 = Session.getDefaultInstance(props);
 
         Message simpleMessage = new MimeMessage(session1);
 
        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;
 
        try {
 
            fromAddress = new InternetAddress(this.from);
            toAddress = new InternetAddress(this.to);
 
        } catch (AddressException e) {
 
            e.printStackTrace();
 
                       JOptionPane.showMessageDialog(null,"Falied to Send mail!!!");
 
        }
 
        try {
 
            simpleMessage.setFrom(fromAddress);
 
            simpleMessage.setRecipient(RecipientType.TO, toAddress);
                         
            simpleMessage.setSubject(this.subject);
 
            simpleMessage.setText(this.text);
 
            Transport transport = session1.getTransport("smtps");
 
            transport.connect (this.sendingHost,sendingPort, this.userName, this.password);
 
            transport.sendMessage(simpleMessage, simpleMessage.getAllRecipients());
 
            transport.close();
 
            //JOptionPane.showMessageDialog(null,"Mail sent");
 
        } catch (MessagingException e) {
 
            e.printStackTrace();
 
                       JOptionPane.showMessageDialog(null, "Falied to Send mail!!!");
 
        }
 
    }
    
}
