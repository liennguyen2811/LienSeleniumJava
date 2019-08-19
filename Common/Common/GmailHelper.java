package Common;

import java.util.Properties;
import Constant.Constant;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class GmailHelper {
	
	public static String getLinkContent(String findBy) {
		System.out.println("getLinkContent 1");
	
		String resetLink = "not found";
		String strResult = new String();
		try {

			String host = Constant.GMAIL_HOST;

			// create properties field
			Properties properties = new Properties();

			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(host, Constant.GMAIL_USERNAME, Constant.GMAIL_PASSWORD);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			System.out.println(emailFolder);
			emailFolder.open(Folder.READ_ONLY); 

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			String subString =  findBy;
			System.out.println("Lien-----------subString: " + subString);
			int n = messages.length;
			
			try {
	        Thread.sleep(100*1000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
			System.out.println("messages.length---n---" + messages.length);
			for (int i = n-1; i > 0 ; i--) {
				String subject = messages[i].getSubject();
				 
			         System.out.println("---------------------------------");
			         System.out.println("Email Number " + (i));
			         System.out.println("Subject: " + messages[i].getSubject());
			         System.out.println("From: " + messages[i].getFrom()[0]);
			         System.out.println("Text: " + messages[i].getContent().toString());
				if (subject.matches(subString)) {
					String strText = messages[i].getContent().toString();
					System.out.println("strText ---------------------------------");
					resetLink = strText;
					System.out.println(resetLink);
					break;
				}
			}

			int indexStart = resetLink.indexOf("href");
			int indexEnd = resetLink.indexOf(">http");
			String resetSubLink = resetLink.substring(indexStart + 6, indexEnd - 1);
			strResult = resetSubLink;
			System.out.println(strResult);

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strResult;

	}
	
	
	/**
	 * Send email using java
	 * @param from
	 * @param pass
	 * @param to
	 * @param subject
	 * @param body
	 */
	public static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {
		System.out.println("if go herer");
        Properties props = System.getProperties();
        System.out.println("props-----------" + props);
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        System.out.println("session-----------" + session);
        MimeMessage message = new MimeMessage(session);

        try {
        	//Set from address
            message.setFrom(new InternetAddress(from));
             message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
           //Set subject
            message.setSubject(subject);
            message.setText(body);
          
            BodyPart objMessageBodyPart = new MimeBodyPart();
            System.out.println("objMessageBodyPart-----------" + objMessageBodyPart);
            
            objMessageBodyPart.setText("Please Find The Attached Report File!");
            
            Multipart multipart = new MimeMultipart();
            System.out.println("multipart-----------" + multipart);
            
            multipart.addBodyPart(objMessageBodyPart);

            objMessageBodyPart = new MimeBodyPart();

            //Set path to the pdf report file
            String filename = System.getProperty("user.dir")+"\\Default test.pdf"; 
            //Create data source to attach the file in mail
            DataSource source = new FileDataSource(filename);
            System.out.println("source-----------" + source);
            
            objMessageBodyPart.setDataHandler(new DataHandler(source));

            objMessageBodyPart.setFileName(filename);

            multipart.addBodyPart(objMessageBodyPart);

            message.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            System.out.println("transport-----------" + transport);
            transport.connect(host, from, pass);
            System.out.println("transport------if go here 1");
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("transport------if go here 2");
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}
