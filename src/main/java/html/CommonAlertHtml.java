/**
 * @author Abhishek
 */
package html;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Nonnull;



public class CommonAlertHtml {

	public String errorCode = "";
	public String errorMessage = ""; 
	public String originalUrl = "";


	public void createReport(HashSet<String>  data, String  originalUrl, String title, String  reportName, String reportFileName)
	{
		//Create report folder, if not exist
		String reportFilepath = System.getProperty("user.dir")+"/reports/";
		File report_folder = new File(reportFilepath);
		if (!report_folder.exists())
		{
			report_folder.mkdir();
		}


		File file = new File(System.getProperty("user.dir") + "/reports/"+reportFileName);
		StringBuilder contentBuilder = new StringBuilder();
		try(
				BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/reports/common_alert_report_template.html"));
				) 
		{
			String str;
			while ((str = in.readLine()) != null)
			{
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException e) 
		{
		}
		String content = contentBuilder.toString();

	@Nonnull	FileWriter fileWriter = null;
	@Nonnull	BufferedWriter bufferedWriter = null;
		try 
		{
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			String htmlPage = content;

			String result = "";
			for (String dataSet : data)
			{
				result = result + "<li>"+dataSet+"</li><hr style=\"display:block;border:0;border-top:1px solid #948f8f\">";
			}

			System.out.println(result);

			htmlPage =  htmlPage.replace("{{URL}}",originalUrl);
			htmlPage = htmlPage.replace("{{MESSAGE-BODY}}", title);
			if(htmlPage.contains("<li>{{ng-result}}</li>"))
			{
				System.out.println("Html page created");
			}
			htmlPage =  htmlPage.replace("<li>{{ng-result}}</li>", result);
			bufferedWriter.write(htmlPage);
			System.out.println("Html page created");
			bufferedWriter.flush();
			fileWriter.flush();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{

				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}

		}

	}



	public void createReport(List<String>  data, String  originalUrl, String title, String  reportName, String reportFileName)
	{


		//Create report folder, if not exist
		String reportFilepath = System.getProperty("user.dir")+"/reports/";
		File report_folder = new File(reportFilepath);
		if (!report_folder.exists())
		{
			report_folder.mkdir();
		}


		File file = new File(System.getProperty("user.dir") + "/reports/"+reportFileName);
		StringBuilder contentBuilder = new StringBuilder();
		try(
				BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/reports/common_alert_report_template.html"));
				) 
		{
			String str;
			while ((str = in.readLine()) != null) 
			{
				contentBuilder.append(str);
			}
			in.close();
		} 
		catch (IOException e)
		{
		}
		String content = contentBuilder.toString();

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			String htmlPage = content;

			String result = "";
			for (String dataSet : data)
			{
				result = result + "<li>"+dataSet+"</li><hr style=\"display:block;border:0;border-top:1px solid #948f8f\">";
			}

			System.out.println(result);

			htmlPage =  htmlPage.replace("{{URL}}",originalUrl);
			htmlPage = htmlPage.replace("{{MESSAGE-BODY}}", title);
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date dt =  new Date();
			htmlPage = htmlPage.replace("{{TIMESTAMP}}", format.format(dt));
			if(htmlPage.contains("<li>{{ng-result}}</li>"))
			{
				System.out.println("Html page created");
			}
			htmlPage =  htmlPage.replace("<li>{{ng-result}}</li>", result);
			bufferedWriter.write(htmlPage);
			System.out.println("Html page created");
			bufferedWriter.flush();
			fileWriter.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally{
			try 
			{

				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}

		}

	}




}
