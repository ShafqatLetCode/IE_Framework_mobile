/**
 * @author Abhishek
 */
package emailer;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
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



public class CommonMailersWithAttachment {
	//********************* Email with attachment *********************

	private static String directory = System.getProperty("user.dir");

	private static final String FROM = "qa@indianexpressdigital.in";
	private static final String SMTP_USERNAME = "AKIAYFPJANSJR6JXONXB";
	private static final String SMTP_PASSWORD = "BE5Z5oQ6LDXnyF7eeeghAajyq4oBq6Wmo79LIdanNdUo"; 
	private static final String HOST = "email-smtp.ap-south-1.amazonaws.com";

	
	
	private void sendAttachmentEmail(Session session, String toEmail, String subject, 
			String messageBody, String reportFileName)  {
		
		String htmlBody = "";
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM, "NoReply-IE"));
			msg.setReplyTo(InternetAddress.parse(FROM, false));
			msg.setSubject(subject, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();
			//Calling function to attach the HTML report in a Email Body
			htmlBody = readFile(System.getProperty("user.dir")+"/reports/"+reportFileName);
			// Fill the bodypart in Email body

			messageBodyPart.setContent(htmlBody, "text/html; charset=UTF-8");
			msg.setContent(htmlBody, "text/html; charset=UTF-8");
			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();
			String screenshotDirectoryName = directory + "/screenshots/";
			File screenshotFile = new File(screenshotDirectoryName);
			if (!screenshotFile.exists()) {
				screenshotFile.mkdir();
			}
			File[] files = new File(screenshotDirectoryName).listFiles();
			String[] attachFiles = new String[files.length + 1];
			int i = 0;
			for (File file : files) {
				if (file.isFile() && i < files.length + 1) {
					attachFiles[i] = file.getAbsolutePath();
				}
				i++;
			}
			attachFiles[files.length] = directory + "/logs/Application.log";


			if (attachFiles != null && attachFiles.length > 0) {
				// creates body part for the attachment
				MimeBodyPart attachPart = null;
				for (String filePath : attachFiles) {
					File f = new File(filePath);
					attachPart = new MimeBodyPart();
					try {
						if (f.exists() && !f.isDirectory()) {
							attachPart.attachFile(filePath);
						} else {
							continue;

						}
					} catch (IOException ex) {
						System.out.println(ex.getMessage());
					}

					multipart.addBodyPart(attachPart);
				}
			}
			multipart.addBodyPart(messageBodyPart);
			// Send the complete message parts
			msg.setContent(multipart);
			msg.saveChanges();

			// Send message
			// Create a transport.
			Transport transport = session.getTransport();
			// Send the message.
			try
			{
				System.out.println("Sending...");
				// Connect to Amazon SES using the SMTP username and password you specified above.
				transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
				// Send the email.
				transport.sendMessage(msg, msg.getAllRecipients());
				System.out.println("Email sent!");
			}

			catch (Exception ex) {
				System.out.println("The email was not sent.");
				System.out.println("Error message: " + ex.getMessage());
			}

			finally
			{
				// Close and terminate the connection.
				transport.close();
			}
			System.out.println("Email Sent Successfully!!");
		} catch (MessagingException | UnsupportedEncodingException e) {
			System.err.println("sendAttachmentEmail Error: " + e.getMessage());
		}

	}

	private static String readFile( String file )  {
		StringBuilder  stringBuilder = new StringBuilder();
		try(

				BufferedReader reader = new BufferedReader( new FileReader (file));

				) {

			String line = null;

			String ls = System.getProperty("line.separator");


			while( ( line = reader.readLine() ) != null ) {
				stringBuilder.append( line );
				stringBuilder.append( ls );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stringBuilder.toString();
	}


	public void sendEmail(String toEmail, String subject, String messageBody, String reportFileName) {

		System.out.println("Sending email to = "+ toEmail);



		Properties props = new Properties();
		/*
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "email-smtp.eu-west-1.amazonaws.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		 */
		
		props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.protocols","TLSv1.2");
        props.put("mail.transport.protocol", "smtp");
		

		//create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, SMTP_PASSWORD);
			}
		};

		Session session = Session.getInstance(props, auth);
		System.out.println("Authorization passed...");



		//Calling Email Function with attachment
		sendAttachmentEmail(session, toEmail, subject, messageBody, reportFileName);

	}     

}
