package html;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class FeedAlertHtml{
	//protected static final Logger APP_LOGS = Logger.getLogger("IELogger");
	public static final String USER_DIRECTORY  = System.getProperty("user.dir");
	public void createReport(List<String> results, String reportName, String apiName, String info, String url) {

		File file = new File(USER_DIRECTORY+"/src/test/resources/reports/feed_alert_template.html");
		File newFile = new File(USER_DIRECTORY+"/reports/"+reportName);

		File folder = new File(USER_DIRECTORY+"/reports/");
		if (!folder.exists()) {
			folder.mkdir();
		}

		try(
				FileReader reader = new FileReader(file);
				BufferedReader br= new BufferedReader(reader);
				FileWriter writer = new FileWriter(newFile);
				BufferedWriter bw = new BufferedWriter(writer);
				) {
			String htmlData = "";
			StringBuilder builder = new StringBuilder();
			while((htmlData = br.readLine())!=null) {
				builder.append(htmlData);
			}

			//Set data in the HTML
			StringBuilder result = new StringBuilder();

			result.append("<tr><td align='center' style='background-color: #AED6F1;'> <b> KEY</b></td>"
					+ "<td align='center' style='background-color: #AED6F1;'><b>ITEMS</b></td></tr>");

			for (int i = 0; i < results.size(); i++) {
				result.append("<tr>");
				result.append("<td align='center'>"+results.get(i)+"</td>");
				result.append("<td align='center'>"+results.get(++i)+"</td>");
				result.append("</tr>");
			}

			String html= "";
			html = builder.toString().replace("{{HEADING}}", apiName);
			html = html.replace("{{SUBJECT}}", info);
			html = html.replace("{{TIMESTAMP}}", "<b>Time: </b>"+getDateAsString());
			html = html.replace("{{Data}}", "<table id='data' border='1' cellpadding='5' cellspacing='0' width='100%' style='font-size: 12px';>"+result.toString()+"</table>");
			html = html.replace("{{URL}}", url);

			bw.write(html);
			System.out.println("HTML Created....");		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public String getDateAsString() {
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
