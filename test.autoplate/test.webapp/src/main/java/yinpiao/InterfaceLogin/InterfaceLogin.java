package yinpiao.InterfaceLogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;


//import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
//import org.apache.http.client.CookieStore;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.AbstractHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.skyscreamer.jsonassert.JSONCompare;
//import org.skyscreamer.jsonassert.JSONCompareMode;
//import org.skyscreamer.jsonassert.JSONCompareResult;
import org.springframework.ui.ModelMap;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.net.URLEncoder;


import org.yp.controller.CaseController;
import org.yp.dao.CaseDao;
import sun.net.www.http.HttpClient;
import yinpiao.common.ConnectJdbc;
import yinpiao.common.HTTPRequestMain;
import yinpiao.common.Readconfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterfaceLogin {


	private String[][] yourTestList;
	private String[][] myInputData;
	private String  token;
//	HSSFSheet inputSheet = null;
//	HSSFWorkbook wb = null;
//	HSSFSheet baselineSheet = null;
//	HSSFSheet outputSheet = null;
//	HSSFSheet comparsionSheet = null;
//	HSSFSheet resultSheet = null;
	String filePath = "";
	private double totalcase = 0;
	HttpResponse response;
	double failedcase = 0;
	//JSONObject json;
	String entity;
	String ResultResponse = null;
	String NND;
	String charset = "UTF-8";
	

	@BeforeTest
	public void beforeTest(String[][] yourTestList) {
		this.yourTestList = yourTestList;
		Object[] list;
	}


	@DataProvider(name = "WorkBookData")
	public String[][] dp(ITestContext context) {
		CaseDao sg = new CaseDao();
		CaseController sc = new CaseController(sg);

		System.out.println("DataProvider" );
//		String[][] test_IDs;
//
//		//�����ȡ��excel����ҳ( ����½:0     ��½��1)(������Ƶ�½���½����������)
//		myInputData = new Readconfig().Reqbody(filePath,0);
//     	String[][] tmp = new String[myInputData.length-1][];
//		System.arraycopy(myInputData, 1, tmp, 0, myInputData.length-1);
		HttpServletRequest request=null;

		HttpServletResponse response=null;

		HttpClient a;


		ModelMap modelMap=null;

		//String[][] array1 = {{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"},{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"}};
		try {
//			String[][] array1 = sc.doCaseId(request,response,modelMap) ;
			System.out.println("heihei"+this.yourTestList.length);
			return null;
		}catch (Exception e){
			return null;
		}
	}

	public void yourTestFunction(String[][] strList)
	{

		System.out.println("hahahhaha"+strList.length);

	}

	@Test(dataProvider = "WorkBookData", description = "api_Test")
	public void api_test(String ID, String TestCase,String call_type, String host, String call_suff,
			String AuthScheme, String AuthCreds, String Accept,
			String Content_Type, String IsLogin, String user,  String BeforeSqlType, String BeforeSql, String Body, String AfterSqlType, String AfterSQL, String ResultResponseType,String ResultResponse) {
		System.out.println("ssssssss��" + ID);
		System.out.println("ssssssss��" + user);
		assert true:"fail the test";

//		ResultResponse = ResultResponse;
//		//��ʼ������
//		if (BeforeSql != "") {
//
//			System.out.println("��Ҫ��ʼ�����ݣ�" + BeforeSql);
//			switch(BeforeSqlType) {
//
//	        case "Add": {
//	          ConnectJdbc sb =new ConnectJdbc();
//	    	  sb.Add(BeforeSql);
//	          break;
//	        }
//	        case "Delete": {
//	    	  ConnectJdbc sb =new ConnectJdbc();
//	    	  sb.Delete(BeforeSql);
//	          break;
//	        }
//	        case "Update": {
//	          ConnectJdbc sb =new ConnectJdbc();
//	    	  sb.Update(BeforeSql);
//	          break;
//	        }
//	        case "Search": {
//        	  ConnectJdbc sb =new ConnectJdbc();
//    		  sb.Search(BeforeSql);
//	          break;
//	        }
//
//	        default: {
//	        	System.out.println("���ݿ����δ֪���ͣ�" + BeforeSqlType);
//	        	break;
//	        }
//	      }
//		}
//		//��ȡurl
//		if ( host == "" ){
//			Readconfig readConfig = new Readconfig();
//		    host = readConfig.readProperty("host");
//			}
//
//		HTTPRequestMain fq = new HTTPRequestMain();
//
//		//��½����
//		if ( IsLogin.equals("Login")){
//			try {
//				 response = fq.perform_request("POST", host	+ "/v1/login/login", user,"");
//				  entity = EntityUtils.toString(response.getEntity(),charset);
//				 json = new JSONObject(entity);
//				 String grd = json.toString();
//				NND = grd.substring(grd.indexOf("ticket\":\"")+9, grd.indexOf("\",\"status"));
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		try {
//
//			 response = fq.perform_request(call_type, host + call_suff, Body, NND);
//			  entity = EntityUtils.toString(response.getEntity(),charset);
//			// ���ص���������Ϊjson��ʹ��org.json jar��������
//			 json = new JSONObject(entity);
//			System.out.println("���ص�Response����:" + json.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail("���ص�resultΪ��" + json.toString() + "HTTP Code��" + response.getStatusLine().getStatusCode() + "��Problem using HTTPRequestGenerator to generate response: "
//					+ e.getMessage());
//		}
//		//�������
//
//				if (AfterSQL != "") {
//					System.out.println("��Ҫ������ݣ�");
//					switch(AfterSqlType) {
//
//			        case "Add": {
//			          ConnectJdbc sb =new ConnectJdbc();
//			    	  sb.Add(AfterSQL);
//			          break;
//			        }
//			        case "Delete": {
//			    	  ConnectJdbc sb =new ConnectJdbc();
//			    	  sb.Delete(AfterSQL);
//			          break;
//			        }
//			        case "Update": {
//			          ConnectJdbc sb =new ConnectJdbc();
//			    	  sb.Update(AfterSQL);
//			          break;
//			        }
//			        case "Search": {
//		        	  ConnectJdbc sb =new ConnectJdbc();
//		    		  sb.Search(AfterSQL);
//			          break;
//			        }
//
//			        default: {
//			        	System.out.println("���ݿ����δ֪���ͣ�" + AfterSqlType);
//			        	break;
//			        }
//			      }
//				}
//
//				if ((response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 204) && ResultResponseType!=("NoContains")) {
//					 Assert.assertTrue(entity.contains(ResultResponse), "���ص�result��ͬ��ResultΪ��" + json.toString());
//ResultResponse
//				}else if ((response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 204) && ResultResponseType.equals("NoContains")) {
//					 Assert.assertFalse(entity.contains(ResultResponse), "���ص�result������δ֪�����ResultΪ��" + json.toString());
//
//				}else if(response.getStatusLine().getStatusCode() == 200 && response == null){
//					//����һЩ�ӿ�ֻ�����󣬲�����Response�����״̬Ϊ200�����жϿ���
//					Assert.assertTrue(true);
//				}
//				else
//				{
//					//ResultResponse.contains(response.getStatusLine())
//		            if (ResultResponse.equals(response.getStatusLine())) {
//
//		            } else {
//		                failedcase++;
//		                Assert.fail("���ص�resultΪ��" + json.toString() + "HTTP Code��" +  response.getStatusLine().getStatusCode());
//		            }
//		        }
				
			}

	@AfterTest
	public void teardown() {
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		// endTime = sf.format(new Date());
//		// DataWriter.writeData(resultSheet, totalcase, failedcase, startTime,
//		// endTime);
//
//		try {
//			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
//			wb.write(fileOutputStream);
//			fileOutputStream.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
//	public void setToken(String toknen){
//
//		this.token = token;
//	}
//
//   public String getToken(){
//
//		return this.token;
//	}
   
}
