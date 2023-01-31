package emailer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;



public class CommonMailer {
	//********************* Email with attachment *********************
	public static Properties CONFIG;
	public static  String total_count;
	public static  String passed_count;
	public static String failed_count;
	public static String skip_count;

	static final String FROM = "qa@indianexpressdigital.net";
	static final String SMTP_USERNAME = "AKIAYFPJANSJ6IKES5EZ";
	static final String SMTP_PASSWORD = "BP4Sy5e5mGo5oBww4y59X+cEGU39NJAbsE2bGN0NjB/j";  
	static final String HOST = "email-smtp.ap-southeast-2.amazonaws.com";

	public void sendAttachmentEmail(Session session, String toEmail, String subject, String reportFileName)  {
		try{
			MimeMessage msg = new MimeMessage(session);      
			msg.setFrom(new InternetAddress(FROM, "NoReply-IE"));
			msg.setReplyTo(InternetAddress.parse(FROM, false));

			msg.setSubject(subject, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			msg.setHeader("X-Priority", "1");
			msg.setHeader("Importance", "High");
			msg.setHeader("Priority", "urgent");

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();
			String body = "";
			//Calling function to attach the HTML report in a Email Body
			try {
				body=readFile(System.getProperty("user.dir")+"/reports/"+reportFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Fill the bodypart in Email body
			messageBodyPart.setContent(body, "text/html; charset=UTF-8");
			msg.setContent(body,"text/html; charset=UTF-8");
			msg.saveChanges();

			// Send message
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

	private static String readFile( String file ) throws Exception {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader( new FileReader (file));
		String         line = null;
		StringBuilder  stringBuilder = new StringBuilder();
		String         ls = System.getProperty("line.separator");

		while( ( line = reader.readLine() ) != null ) {
			stringBuilder.append( line );
			stringBuilder.append( ls );
		}

		return stringBuilder.toString();
	}


	public String errorCode = "";
	public String errorMessage = "";

	public void send_email(String toEmail, String url, String message, String reportFileName) {
		System.out.println("Sending email to = "+ toEmail);



		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", "587");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.ssl.protocols","TLSv1.2");

		//create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM,SMTP_PASSWORD);
			}
		};

		Session session = Session.getInstance(props, auth);
		// System.out.println(CONFIG.getProperty("testSiteURL"));
		System.out.println("Authorization passed...");



		//Calling Email Function with attachment
		sendAttachmentEmail(session, toEmail, message, reportFileName);

	}    

}