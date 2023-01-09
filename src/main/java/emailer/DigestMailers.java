package emailer;

import java.io.File;
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

public class DigestMailers {
	//********************* Email with attachment *********************
	private static String directory = System.getProperty("user.dir");


	private static final String FROM = "qa@indianexpressdigital.in";
	private static final String SMTP_USERNAME = "AKIAYFPJANSJUJYNBVGX";
	private static final String SMTP_PASS = "BP4W7bXxGEjKoek3I6ec9FTQplEJZKfn31mKb68DfHuK";  
	private static final String HOST = "email-smtp.ap-southeast-1.amazonaws.com";


	public void sendAttachmentEmail(Session session, String toEmail, String subject, String messageBody, String reportFileName)  {
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
			htmlBody = messageBody;
			// Fill the bodypart in Email body

			messageBodyPart.setContent(htmlBody, "text/html");
			msg.setContent(htmlBody, "text/html");
			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();
			String[] attachFiles = new String[2];
	
			attachFiles[0] = directory + "/logs/Application.log";
			attachFiles[1] = directory + "/reports/"+reportFileName;

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

			// Create a transport.

			Transport transport = session.getTransport();



			// Send the message.

			try      {

				System.out.println("Sending...");

				// Connect to Amazon SES using the SMTP username and password you specified above.
				transport.connect(HOST, SMTP_USERNAME, SMTP_PASS);
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

	

	public void sendEmail(String toEmail, String subject, String messageBody, String reportFileName) {
		System.out.println("Sending email to = "+ toEmail);



		Properties props = new Properties();
		/*props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", "587");
		props.put("mail.transport.protocol", "smtp");
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
				return new PasswordAuthentication(FROM, SMTP_PASS);
			}
		};

		Session session = Session.getInstance(props, auth);
		System.out.println("Authorization passed...");



		//Calling Email Function with attachment
		sendAttachmentEmail(session, toEmail, subject, messageBody, reportFileName);

	}     

}
