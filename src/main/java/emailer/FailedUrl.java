package emailer;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestResult;
import org.testng.internal.TestResult;


public class FailedUrl {

	private List<ArrayList<String>> url_failed_list = new ArrayList<ArrayList<String>>();
	private int serialNo=1;

	/**
	 * return failed url list
	 * @return
	 */
	public List<ArrayList<String>> getUrlFailedList() {
		return url_failed_list;
	}

	//	public void addUrlToList(ITestResult testResult, String url, String message) {
	//		int flag=0;
	//		if(testResult.getStatus()== ITestResult.FAILURE) {
	//			if(flag==0) {
	//				String domain=utility.getDomain(url);
	//				addDataInList(serialNo+"<td rowspan='1'><b>"+domain+"</b></td>",
	//						url,
	//						message);
	//				serialNo++;
	//				flag=1;
	//			}
	//			else{
	//				addDataInList(serialNo+"",
	//						url,
	//						message);
	//				serialNo++;
	//			}
	//	}
	//}

	/**
	 * Adding values in the failed url list
	 * @param value1
	 * @param value2
	 * @param value3
	 */
	public void addDataInList(String value1, String value2, String value3) {
		ArrayList<String> data = new ArrayList<>();
		data.add(value1);
		data.add(value2);
		data.add(value3);

		url_failed_list.add(data);
	}

	public void addUrlToList(ITestResult testResult, String url, String message) {
		// TODO Auto-generated method stub
		int flag=0;
		if(testResult.getStatus()== ITestResult.FAILURE) {
			if(flag==0) {
				String domain="Indian Express";
				addDataInList(serialNo+"<td rowspan='1'><b>"+domain+"</b></td>",
						url,
						message);
				serialNo++;
				flag=1;
			}
			else{
				addDataInList(serialNo+"",
						url,
						message);
				serialNo++;
			}
		}
	}
	
	public List<String> getTableHeadings(){
		List<String> tableHeading =  new ArrayList<>();
		tableHeading.add("SNo"+"<td><b>Application Name"+ "</b></td>");
		tableHeading.add("Failed Testcase");
		tableHeading.add("Testcase Discription");
		return tableHeading;
	}



}
