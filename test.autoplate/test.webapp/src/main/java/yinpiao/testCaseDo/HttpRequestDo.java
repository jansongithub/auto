package yinpiao.testCaseDo;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.yp.dao.CaseDao;
import org.yp.pojo.ResultPo;
import yinpiao.common.ConnectJdbc;

import javax.servlet.http.HttpServletResponse;


/**
 * HttpClient执行请求
 * Created by zhanxiaobing on 2016/8/18.
 */

public class HttpRequestDo {
    HttpResponse response;
    String entity;
    String charset = "UTF-8";
    JSONObject json;
    String NND;
	double failedcase = 0;
	HttpServletResponse httpServletResponse;
//	private ResultPo resultPo;

//	public ResultDao getResultDao() {
//		return resultDao;
//	}
//
//	public void setCaseDao(ResultDao caseDao) {
//		this.resultDao = caseDao;
//	}


	public ResultPo apiTest(JSONObject jsonObject)  throws Exception{
        /*
         *       String TestCase,String call_type, String host, String call_suff,
         *       String AuthScheme, String AuthCreds, String Accept,
          *      String Content_Type, String IsLogin, String user,  String BeforeSqlType, String BeforeSql, String Body, String AfterSqlType, String AfterSQL, String ResultResponseType,String ResultResponse
         */
        String ID = jsonObject.getString("id");
        String call_type = jsonObject.getString("method");
        String host = jsonObject.getString("host");
        String call_suff = jsonObject.getString("URI");
        String IsLogin = jsonObject.getString("islogin");
        String user = jsonObject.getString("loginname");
        String BeforeSqlType = jsonObject.getString("beforeSqlType");
        String BeforeSql = jsonObject.getString("beforeSql");
        String Body = jsonObject.getString("body");
        String AfterSqlType = jsonObject.getString("afterSQLType");
        String AfterSQL = jsonObject.getString("afterSQL");
        String ResultResponseType = jsonObject.getString("resultResponseType");
        String ResultResponse = jsonObject.getString("resultResponse");
		String resultNote;
		ResultPo resultPo = new ResultPo();
/*
        System.out.println("id:" + jsonObject.getString("id"));
        System.out.println("loginname:" + jsonObject.getString("loginname"));
        System.out.println("casename:" + jsonObject.getString("casename"));
  */

		ResultResponse = ResultResponse;
		//初始化数据
		if (BeforeSql.length() > 5 ) {

			System.out.println("需要初始化数据:" + BeforeSql);

			if (BeforeSqlType.equals("Add")){

				ConnectJdbc sb =new ConnectJdbc();
				sb.Add(BeforeSql);

			}else if (BeforeSqlType.equals("Delete")){

				ConnectJdbc sb =new ConnectJdbc();
				sb.Delete(BeforeSql);

			}else if (BeforeSqlType.equals("Update")){

				ConnectJdbc sb =new ConnectJdbc();
				sb.Update(BeforeSql);

			}else if (BeforeSqlType.equals("Search")){

				ConnectJdbc sb =new ConnectJdbc();
				sb.Search(BeforeSql);

			}else {

				System.out.println("数据库操作未知类型:" + BeforeSqlType);

			}
/*			switch 不支持String
				switch(BeforeSqlType) {

	        case "Add": {
	          ConnectJdbc sb =new ConnectJdbc();
	    	  sb.Add(BeforeSql);
	          break;
	        }
	        case "Delete": {
	    	  ConnectJdbc sb =new ConnectJdbc();
	    	  sb.Delete(BeforeSql);
	          break;
	        }
	        case "Update": {
	          ConnectJdbc sb =new ConnectJdbc();
	    	  sb.Update(BeforeSql);
	          break;
	        }
	        case "Search": {
        	  ConnectJdbc sb =new ConnectJdbc();
    		  sb.Search(BeforeSql);
	          break;
	        }

	        default: {
	        	System.out.println("数据库操作未知类型:" + BeforeSqlType);
	        	break;
	        }
	      }

	      */
		}
        HttpRequestClient fq = new HttpRequestClient();
		//登陆请求
		if ( IsLogin.equals("Login")){
			try {
				 response = fq.perform_request("POST", host + "/v1/login/login", user, "");
				  entity = EntityUtils.toString(response.getEntity(), charset);
				// json = new JSONObject(entity);
				json = JSONObject.fromObject(entity);
				 String grd = json.toString();
				NND = grd.substring(grd.indexOf("ticket\":\"")+9, grd.indexOf("\",\"uid\""));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {

			 response = fq.perform_request(call_type, host + call_suff, Body, NND);
			  entity = EntityUtils.toString(response.getEntity(),charset);
			// 返回的数据类型为json，使用org.json jar包来解析
			json = JSONObject.fromObject(entity);
			System.out.println("返回的Response内容:" + json.toString());
		} catch (Exception e) {
			e.printStackTrace();
			 resultNote = "result is:" +  "http请求出错,Problem using HTTPRequestGenerator to generate response:" +
					e.getMessage();
//			httpServletResponse.getWriter().write("返回的result为:" + json.toString() + "HTTP Code:" + response.getStatusLine().getStatusCode() + "。Problem using HTTPRequestGenerator to generate response:"
//					+ e.getMessage());
//			Assert.fail("返回的result为:" + json.toString() + "HTTP Code:" + response.getStatusLine().getStatusCode() + "。Problem using HTTPRequestGenerator to generate response:"
//					+ e.getMessage());

			//caseDao.saveCaseDoResult(1,Long.parseLong(ID),"fail",resultNote);
			resultPo.setTestcase_id(Long.parseLong(ID));
			resultPo.setTestplan_id(1);
			resultPo.setResult_Status("Fail");
			resultPo.setResult_Response(resultNote);

			return resultPo;
		}
		//清除数据

				if (AfterSQL.length() > 5  ) {
					System.out.println("需要清除数据:");
					if (AfterSqlType.equals("Add")) {

						ConnectJdbc sb =new ConnectJdbc();
						sb.Add(AfterSQL);

					}else if (AfterSqlType.equals("Delete")) {

						ConnectJdbc sb =new ConnectJdbc();
						sb.Delete(AfterSQL);

					}else if (AfterSqlType.equals("Update")) {

						ConnectJdbc sb =new ConnectJdbc();
						sb.Update(AfterSQL);

					}else if (AfterSqlType.equals("Search")) {

						ConnectJdbc sb =new ConnectJdbc();
						sb.Search(AfterSQL);

					}else {

						System.out.println("数据库操作未知类型:" + AfterSqlType);

					}
					/* switch不支持String
					switch(AfterSqlType) {

			        case "Add": {
			          ConnectJdbc sb =new ConnectJdbc();
			    	  sb.Add(AfterSQL);
			          break;
			        }
			        case "Delete": {
			    	  ConnectJdbc sb =new ConnectJdbc();
			    	  sb.Delete(AfterSQL);
			          break;
			        }
			        case "Update": {
			          ConnectJdbc sb =new ConnectJdbc();
			    	  sb.Update(AfterSQL);
			          break;
			        }
			        case "Search": {
		        	  ConnectJdbc sb =new ConnectJdbc();
		    		  sb.Search(AfterSQL);
			          break;
			        }

			        default: {
			        	System.out.println("数据库操作未知类型:" + AfterSqlType);
			        	break;
			        }
			      }
					*/
				}

				if ((response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 204) && ResultResponseType!=("NoContains")) {
				//	 Assert.assertTrue(entity.contains(ResultResponse), "返回的result不同，Result为:" + json.toString());
					if( entity.contains(ResultResponse) ){
						resultNote = "Result is:" + json.toString();
						System.out.println(resultNote);
						//resultController.testJDBCDaoInsert(1, 65, "pass", resultNote);
						//caseDao.saveCaseDoResult(1, 65, "pass", resultNote);
						//return true;
						resultPo.setTestcase_id(Long.parseLong(ID));
						resultPo.setTestplan_id(1);
						resultPo.setResult_Status("PASS");
						resultPo.setResult_Response(resultNote);

						return resultPo;
					}else {
						//httpServletResponse.getWriter().write("返回的result不同，Result为:" + json.toString());
						resultNote = "Result is:" + json.toString();
//						caseDao.saveCaseDoResult(1,Long.parseLong(ID),"fail",resultNote);
//						return false;
						resultPo.setTestcase_id(Long.parseLong(ID));
						resultPo.setTestplan_id(1);
						resultPo.setResult_Status("Fail");
						resultPo.setResult_Response(resultNote);

						return resultPo;
					}

				}else if ((response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 204) && ResultResponseType.equals("NoContains")) {
					// Assert.assertFalse(entity.contains(ResultResponse), "返回的result包含了未知结果，Result为:" + json.toString());
					if( entity.contains(ResultResponse) ){
						//httpServletResponse.getWriter().write("返回的result包含了未知结果，Result为:" + json.toString());
						resultNote = "Result is:" + json.toString();
//						caseDao.saveCaseDoResult(1, Long.parseLong(ID), "fail", resultNote);
//						return false;
						resultPo.setTestcase_id(Long.parseLong(ID));
						resultPo.setTestplan_id(1);
						resultPo.setResult_Status("Fail");
						resultPo.setResult_Response(resultNote);

						return resultPo;
					}else {
						resultNote = "Result is:" + json.toString();
//						caseDao.saveCaseDoResult(1,Long.parseLong(ID),"pass",resultNote);
//						return true;
						resultPo.setTestcase_id(Long.parseLong(ID));
						resultPo.setTestplan_id(1);
						resultPo.setResult_Status("PASS");
						resultPo.setResult_Response(resultNote);

						return resultPo;
					}

				}else if(response.getStatusLine().getStatusCode() == 200 && response == null){
					//对于一些接口只做请求，不返回Response，如果状态为200，就判断可用
				//	Assert.assertTrue(true);
					resultNote = "Result is:" + json.toString();
//					caseDao.saveCaseDoResult(1,Long.parseLong(ID),"pass",resultNote);
//					return true;
					resultPo.setTestcase_id(Long.parseLong(ID));
					resultPo.setTestplan_id(1);
					resultPo.setResult_Status("PASS");
					resultPo.setResult_Response(resultNote);

					return resultPo;
				}
				else
				{
					//ResultResponse.contains(response.getStatusLine())
		            if (ResultResponse.equals(response.getStatusLine())) {
						resultNote = "Result is:" + json.toString();
//						caseDao.saveCaseDoResult(1,Long.parseLong(ID),"pass",resultNote);
//						return true;
						resultPo.setTestcase_id(Long.parseLong(ID));
						resultPo.setTestplan_id(1);
						resultPo.setResult_Status("PASS");
						resultPo.setResult_Response(resultNote);

						return resultPo;

		            } else {
		                failedcase++;
						//httpServletResponse.getWriter().write("返回的result为:" + json.toString() + "HTTP Code:" +  response.getStatusLine().getStatusCode());
						resultNote = "Result is:" + json.toString() + "HTTP Code:" +  response.getStatusLine().getStatusCode();
//						caseDao.saveCaseDoResult(1, Long.parseLong(ID), "fail", resultNote);
//						return false;
						resultPo.setTestcase_id(Long.parseLong(ID));
						resultPo.setTestplan_id(1);
						resultPo.setResult_Status("Fail");
						resultPo.setResult_Response(resultNote);

						return resultPo;
		             //   Assert.fail("返回的result为:" + json.toString() + "HTTP Code:" +  response.getStatusLine().getStatusCode());
		            }
		        }

    }
}
