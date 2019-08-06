package Common;

import java.util.Properties;
import Constant.Constant;
import javax.mail.*;

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

}
