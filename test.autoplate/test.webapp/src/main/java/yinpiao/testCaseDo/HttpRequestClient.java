package yinpiao.testCaseDo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by zhanxiaobing on 2016/8/19.
 */
public class HttpRequestClient {

	//private  String call_type = "GET";
	HttpResponse response = null;
	//public static HttpClient httpClient = new CloseableHttpClient(new PoolingClientConnectionManager());
    CloseableHttpClient httpclient = HttpClients.createDefault();


	public HttpResponse perform_request(String call_type,String url,String body, String atoken) throws Exception{
	try {
		String charset = "UTF-8";
			if (call_type.equals("GET")) {

				HttpGet httpGet = new HttpGet(url);
				httpGet.addHeader("atoken", atoken);
				response = httpclient.execute(httpGet);

			}else if (call_type.equals("POST")) {

				StringEntity params =new StringEntity(body);
				HttpPost HttpPost = new HttpPost(url);
				HttpPost.addHeader("atoken", atoken);
				HttpPost.addHeader("content-type", "application/json");
				HttpPost.setEntity(params);
				response=httpclient.execute(HttpPost);

		}else if (call_type.equals("PUT")) {

				StringEntity params =new StringEntity(body);
				HttpPut HttpPut = new HttpPut(url);
				HttpPut.addHeader("atoken", atoken);
				HttpPut.addHeader("content-type", "application/json");
				HttpPut.setEntity(params);
				response=httpclient.execute(HttpPut);

		}else if (call_type.equals("DELETE")) {

				HttpDelete httpDel = new HttpDelete(url);
				httpDel.addHeader("atoken", atoken);
				response = httpclient.execute(httpDel);

		}else  {

				System.out.println("未知类型" + call_type);

		}
	   		/*  switch 不支持String
	         switch(call_type) {

	        case "GET": {
	        	 HttpGet httpGet = new HttpGet(url);
	        	 httpGet.addHeader("atoken", atoken);
	        	 response = httpclient.execute(httpGet);

	          break;
	        }
	        case "POST": {
	            StringEntity params =new StringEntity(body);
	        	HttpPost HttpPost = new HttpPost(url);
	        	HttpPost.addHeader("atoken", atoken);
	        	HttpPost.addHeader("content-type", "application/json");
	        	HttpPost.setEntity(params);
	        	response=httpclient.execute(HttpPost);

	          break;
	        }
	        case "PUT": {
	        	StringEntity params =new StringEntity(body);
	        	HttpPut HttpPut = new HttpPut(url);
	        	HttpPut.addHeader("atoken", atoken);
	        	HttpPut.addHeader("content-type", "application/json");
	        	HttpPut.setEntity(params);
	        	response=httpclient.execute(HttpPut);

	          break;
	        }
	        case "DELETE": {
	        	HttpDelete httpDel = new HttpDelete(url);
	        	httpDel.addHeader("atoken", atoken);
	        	 response = httpclient.execute(httpDel);

	          break;
	        }

	        default: {
	        	System.out.println("未知类型" + call_type);
	        	break;
	        }
	      }
	      */

	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.printf("Problem performing request: ", e);
	    }

	return  response;

	}
}
