package html;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;


public class AlertHtml
{
	//protected static final Logger APP_LOGS = Logger.getLogger("IELogger");
    public static final String USER_DIRECTORY  = System.getProperty("user.dir");
	public void createReport(List<String> tableHeadings, List<ArrayList<String>> data ,String reportName, 
			String subject, String url, String owner, String alertName) {
		File file = new File(USER_DIRECTORY+"/src/test/resources/reports/alert_report.html");
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
			StringBuilder htmlContent = new StringBuilder();
			while((htmlData = br.readLine())!=null) {
				htmlContent.append(htmlData);
			}
			//Set data in the HTML
			StringBuilder result = new StringBuilder();
			
			int count = tableHeadings.size();
			result.append("<tr>");
			for(int i=0;i<count;i++)
			{
				if(tableHeadings.get(i).contains("<th")){
					result.append(tableHeadings.get(i));
				}
				else
					result.append("<th><b>" + tableHeadings.get(i)+ "</b></th>");
			}
			result.append("</tr>");
		
			for (int i = 0; i < data.size(); i++) 
			{
				result.append("<tr>");
				for(int j=0;j<count;j++)
				{
					if(data.get(i).get(j).isEmpty()) {
						continue;
					}
					if(data.get(i).get(j).contains("<td"))
						result.append(data.get(i).get(j));
					else
						result.append("<td>" +data.get(i).get(j)+"</td>");
				}
				result.append("</tr>");
				
			}

			String html= "";
			html = htmlContent.toString().replace("{{MESSAGE-BODY}}", subject);
			html = html.replace("{{TIMESTAMP}}", "<b>Time: </b>"+getDateAsString());
			html = html.replace("{{DataSet}}",result.toString());
			html = html.replace("{{URL}}", url);
			html = html.replace("{{REPORTER-NAME}}",owner);
			html = html.replace("{{REPORT-NAME}}", alertName);

			bw.write(html);
			System.out.println("HTML Created....");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String getDateAsString() {
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
}
