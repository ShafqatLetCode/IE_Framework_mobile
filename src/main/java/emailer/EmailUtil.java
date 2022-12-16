package emailer;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

/**
 * @Author Abhishek
 * @ver 1.0
 * @since 2020
 */
public class EmailUtil
{


	//********************* Email with attachment *********************
	private static Properties CONFIG;
	private static int passedCase;
	private static int failedItems;
	private static int skipItems;
	private static final String SERVER_NAME = "preprod";
    private static final String USER_EMAIL =   "abhishek.dhoundiyal@indianexpress.com, richa.sharma@indianexpress.com, pooja.bisht@indianexpress.com, atisri.chandel@indianexpress.com"
    + " deepak@myinsuranceclub.com, ameya@myinsuranceclub.com, ganesh@myinsuranceclub.com";

    private static String directory = System.getProperty("user.dir");
	private static Logger logger = Logger.getLogger("MICLogger");


	private static final String FROM = "qa@indianexpressdigital.in";
	private static final String SMTP_USERNAME = "AKIAYFPJANSJR6JXONXB";
	private static final String SMTP_PASS = "BE5Z5oQ6LDXnyF7eeeghAajyq4oBq6Wmo79LIdanNdUo";
	private static final String HOST = "email-smtp.ap-south-1.amazonaws.com";


	private static void sendAttachmentEmail(Session session, String toEmail, String subject, String body)
	{
		String htmlBody = body;
		try
		{
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM, "NoReply-IE"));
			msg.setReplyTo(InternetAddress.parse(FROM, false));
			msg.setSubject(subject, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();
			//Calling function to attach the HTML report in a Email Body
			htmlBody = readFile(directory + CONFIG.getProperty("customReport"));
			// Fill the bodypart in Email body
			//htmlBody = htmlBody.replace("<tr><td style='display:none;'>{{ng-report}}</td></tr>", createResult());

			messageBodyPart.setContent(htmlBody, "text/html; charset=UTF-8");
			msg.setContent(htmlBody, "text/html");
			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();
			String screenshotDirectoryName = directory + CONFIG.getProperty("scrfolder");
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
					try
					{
						if (f.exists() && !f.isDirectory())
						{
							attachPart.attachFile(filePath);
						}
						else {
							continue;
						}
					}
					catch (IOException ex)
					{
						logger.error(ex.getMessage());
					}

					multipart.addBodyPart(attachPart);
				}
			}
			multipart.addBodyPart(messageBodyPart);
			// Send the complete message parts
			msg.setContent(multipart);
			msg.saveChanges();
			// Create a transport.
			transportEmail(session, msg);

		}
		catch (Exception e)
		{
			logger.error("sendAttachmentEmail Error: " + e.getMessage());
		}
	}

	/**
	 * Create a transport.
	 * @param session
	 * @param msg
	 */
	public static void transportEmail(Session session, MimeMessage msg)  {
		// Send the message.
		try
		{
			Transport transport = session.getTransport();
			logger.debug("Sending email please wait.......");
			// Connect to Amazon SES using the SMTP username and password you specified above.
			transport.connect(HOST, SMTP_USERNAME, SMTP_PASS);
			// Send the email.
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			logger.debug("Email Sent Successfully!!");
		}

		catch (Exception ex) {
			logger.debug("The email was not sent.");
			logger.debug("Error message: " + ex.getMessage());

		}
	}


	private static String readFile(String file)
	{
		StringBuilder stringBuilder = null;
		String fileData = "";
		try
				(
						BufferedReader reader = new BufferedReader(new FileReader(file))
				)
		{
			String line = null;
			stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			fileData = stringBuilder.toString();
		}
		catch (Exception e)
		{
			logger.error("File read Error: " + e.getMessage());
		}

		return fileData;
	}

	public static final int NUMBER_OF_RESULT_SET = 4;

	public static void main(String[] args) throws Exception {
		try (
				FileInputStream cn = new FileInputStream(directory + "/src/test/resources/config/CONFIG.properties")
		) {
			CONFIG = new Properties();
			System.setProperty("logfilename", directory + "/logs/Application.log");
			PropertyConfigurator.configure(directory + "/src/test/resources/config/log4j.properties");
			CONFIG.load(cn);

			String[] testResultList = new String[NUMBER_OF_RESULT_SET];
			int totalcase = 0;

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			docBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			docBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(directory + CONFIG.getProperty("testngResultFile")));
			// normalize text representation
			doc.getDocumentElement().normalize();
			NodeList results = doc.getElementsByTagName("testng-results");
			Element firstNameElement = (Element) results.item(0);
			NamedNodeMap r2 = firstNameElement.getAttributes();
			// get the pass, fail and skip counts of test case execution
			totalcase = Integer.parseInt(r2.getNamedItem("total").getNodeValue());
			passedCase = Integer.parseInt(r2.getNamedItem("passed").getNodeValue());
			failedItems = Integer.parseInt(r2.getNamedItem("failed").getNodeValue());
			skipItems = Integer.parseInt(r2.getNamedItem("skipped").getNodeValue());
			logger.debug("Total: " + totalcase + " Passed: " + passedCase + " Failed: " + failedItems + " skipped: " + skipItems);
			testResultList[0] = "Total: " + totalcase;
			testResultList[1] = "Passed: " + passedCase;
			testResultList[2] = "failed: " + failedItems;
			testResultList[3] = "Skipped: " + skipItems;

			logger.debug("======>>Test Case Evaluation<<=======");
			logger.debug("TOTAL: " + totalcase);
			logger.debug("PASSED: " + passedCase);
			logger.debug("FAILED: " + failedItems);
			logger.debug("SKIPPED: " + skipItems);

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
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(FROM, SMTP_PASS);
				}
			};

			Session session = Session.getInstance(props, auth);
			logger.debug("Email Authorization passed...");

			/**
			 * Send result summary
			 */
			String baseURL ="";
			String buildUrl = System.getenv("testUrl");
			if(buildUrl!=null)
			{
				baseURL = buildUrl;
			}
			else
				baseURL = CONFIG.getProperty("micURL");
			String message = "MyInsuranceClub.com - Automation Report : ";
			//Calling Email Function with attachment
			EmailUtil.sendAttachmentEmail(session, USER_EMAIL, message + Arrays.toString(testResultList), "Hi all, Check your Automation report with attached logs.");
		}
		catch (Exception e)
		{
			logger.error("Error: " + e.getMessage());
		}
	}


//	private static String createResult() {
//		String baseUrl = "";
//		String buildUrl = System.getenv("testUrl");
//		if(buildUrl!=null)
//		{
//			baseUrl = buildUrl;
//		}
//		else
//			baseUrl = CONFIG.getProperty("micURL");
//		try
//		{
//			int total = passedCase + failedItems + skipItems;
//
//			String data = "<tr><td colspan=2 align=center style='font-size:26px; color:#002d66;'>" + total + "<br>Total</td>"
//					+ "<td colspan=2 align=center style='font-size:26px; color:#33ff33;'>" + passedCase + "<br>PASSED</td>"
//					+ "<td colspan=2 align=center style='font-size:26px; color:salmon;'>" + failedItems + "<br>FAILED</td>"
//					+ "<td colspan=2 align=center style='font-size:26px; color: #ffce01;'>" + skipItems + "<br>SKIPPED</td></tr>";
//
//			data = data + createGraph();
//			data = data + createBrowserInfo();
//			data = getIPAddress(baseUrl, data);
//			return data;
//
//		}
//		catch (Exception e)
//		{
//			logger.error("Error: " + e.getMessage());
//			return "<td colspan=8></td>";
//		}
//
//
//	}

	/**
	 * Hack method to send OS, Browser Details using Webdriver and WebDriverManager
	 * @return HTML Data
	 */
//	private static String createBrowserInfo() {
//		try {
//			String operatingSystem = System.getProperty("os.name");
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--no-sandbox");
//			options.addArguments("--disable-dev-shm-usage");
//			options.addArguments("--headless");
//			WebDriver driver = new ChromeDriver(options);
//			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
//
//			String browserName = cap.getBrowserName().toUpperCase();
//			String browserVersion = (String) cap.getCapability("browserVersion");
//
//			String data = "<tr style='background:#f36622;'>"
//					+ "<td colspan=2 align=center style='font-size:14px; color:white;'> <b>OS</b> <br><b>" + operatingSystem + " - " + WebDriverManager.globalConfig().getArchitecture().name() + "</b></td>"
//					+ "<td colspan=3 align=center style='font-size:14px; color:white;'>" + "<b>Browser Name</b>" + "<br><b>" + browserName + "</b></td>"
//					+ "<td colspan=3 align=center style='font-size:14px; color:white;'><b>Browser Version</b> <br><b>" + browserVersion + "</b></td>"
//					+ "</tr>";
//			return data;
//		}
//		catch (Exception ex){
//			ex.printStackTrace();
//			return "";
//		}
//	}

	/**
	 *
	 * @param baseUrl
	 * @param data
	 * @return
	 */
	public static String getIPAddress(String baseUrl, String data){
		try {
			InetAddress address = InetAddress.getByName(new java.net.URL(baseUrl).getHost());
			String ip = address.getHostAddress();
			if (directory.toLowerCase().contains(SERVER_NAME))
				ip = System.getenv("build");
			logger.debug("IP Address = "+ip);
			logger.debug("Host Address = "+address.getCanonicalHostName());
			String ipData = "<tr style='background:#00c0e4;'>"
					+ "<td colspan=2 align=center style='font-size:14px; color:white;'>" + ip + "<br><b>IP Address</b></td>"
					+ "<td colspan=6 align=center style='font-size:14px; color:white;'>" + address.getCanonicalHostName() + "<br><b>Host Name</b></td>"
					+ "</tr>";
			data = data + ipData;
		} catch (Exception e) {
			logger.error("Erro in Getting ip address: " + e.getMessage());
		}
		return data;
	}

	private static String createGraph() {
		try {
			logger.debug("Passed case: " + passedCase);
			logger.debug("Failed case: " + failedItems);
			logger.debug("Skipped case: " + skipItems);
			int totalCases = passedCase + failedItems + skipItems;
			int passedPercent = (passedCase * 100) / totalCases;
			int failedPercent = (failedItems * 100) / totalCases;
			int skippedPercent = (skipItems * 100) / totalCases;
			logger.debug(totalCases);
			logger.debug("Passed case %: " + passedPercent);
			logger.debug("Failed case %: " + failedPercent);
			logger.debug("Skipped case %: " + skippedPercent);

			if (passedPercent < 4) {
				passedPercent = (passedCase * 100) / totalCases;
			}

			if (skippedPercent < 4) {
				skippedPercent = (skipItems * 100) / totalCases;
			}

			if (failedPercent < 4) {
				failedPercent = (failedItems * 100) / totalCases;
			}

			return "<tr>\n" +
					"<td colspan=\"8\"><br>\n" +
					"<img src=\"https://image-charts.com/chart?cht=bvg&chd=t:100,"
					+ passedPercent + ","
					+ failedPercent + ","
					+ skippedPercent +
					"&chco=76A4FB|dff4b6|fbc7a0|ffff00&chxt=x,y&chxl=0:"
					+ "|Total|Passed|Failed|Skipped&chs=700x200\">\n" +
					"    </td>\n" +
					"</tr>";

		} catch (Exception e) {
			logger.error("Error in creating graph: " + e.getMessage());
			return "";
		}

	}


}	            