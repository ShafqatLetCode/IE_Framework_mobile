package html;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class AMP_ALERT_HTML {

	public String errorCode = "";
	public String errorMessage = ""; 
	public String originalUrl = "";


	public void create_amp_aler_report(List<String> jsonResp, String  reportName, String reportFileName){



		//Create report folder, if not exist
		String reportFilepath = System.getProperty("user.dir")+"/reports/";
		File report_folder = new File(reportFilepath);
		if (!report_folder.exists()){
			report_folder.mkdir();
		}


		File file = new File(System.getProperty("user.dir") + "/reports/"+reportFileName);
		StringBuilder contentBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/reports/amp_alert_report_template.html"));
			String str;
			while ((str = in.readLine()) != null) {
				contentBuilder.append(str);
			}
			in.close();
		} catch (IOException e) {
		}
		String content = contentBuilder.toString();

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			String htmlPage = content;
			String data = "";
			for(int i=0;i<jsonResp.size();i++) {
				JSONObject obj = new JSONObject(jsonResp.get(i));
				JSONArray urlErrors = obj.getJSONArray("urlErrors");
				errorCode = ((JSONObject)urlErrors.get(0)).getString("errorCode");
				System.out.println(errorCode);
				errorMessage = ((JSONObject)urlErrors.get(0)).getString("errorMessage");
				System.out.println(errorMessage);
				originalUrl = ((JSONObject)urlErrors.get(0)).getString("originalUrl");
				System.out.println(originalUrl);
				
				data =  data + "<li>originalUrl: "+originalUrl+ "<br> Error Code: "+errorCode+ "<br>Error Message: "+errorMessage+"<br><hr style=\"display:block;border:0;border-top:1px solid #948f8f\"></li>";
			}
			
			htmlPage =  htmlPage.replace("{{timestamp}}", getDateAsString());
			
			htmlPage =  htmlPage.replace("{{RESULTS}}",data);
			
			bufferedWriter.write(htmlPage);
			System.out.println("Html page created");
			bufferedWriter.flush();
			fileWriter.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {

				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Method to get Date as String
	 *
	 * @return
	 */
	public String getDateAsString() {
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss a");
			Date date = new Date();
			return dateFormat.format(date);
		} catch (Exception e) {
			return "";
		}
		
	}



	public void jsonParser(String json) {
		JSONObject obj = new JSONObject(json);
		JSONArray urlErrors = obj.getJSONArray("urlErrors");
		errorCode = ((JSONObject)urlErrors.get(0)).getString("errorCode");
		System.out.println(errorCode);
		errorMessage = ((JSONObject)urlErrors.get(0)).getString("errorMessage");
		System.out.println(errorMessage);
		originalUrl = ((JSONObject)urlErrors.get(0)).getString("originalUrl");
		System.out.println(originalUrl);
	}



}
