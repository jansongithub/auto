package yinpiao.common;

//import java.util.List;
//import java.util.Map;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.CookieStore;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpDelete;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpPut;
//import org.apache.http.cookie.Cookie;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.AbstractHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.conn.PoolingClientConnectionManager;
//import org.apache.http.util.EntityUtils;
////import org.json.JSONObject;
//
//import yinpiao.InterfaceLogin.InterfaceLogin;


public class HTTPRequestMain {
//	private static String call_string = "https://apitest.yinpiao.com/api/v1/cfca/downCFCA/23057/501295";
//	private  String call_type = "GET";
//	HttpResponse response = null;
//	public static HttpClient httpClient = new DefaultHttpClient(new PoolingClientConnectionManager());
//
//	public static void main(String args[]) throws Exception{
//		HTTPRequestMain sb =  new HTTPRequestMain();
//
//		HttpResponse sd = sb.perform_request("GET",call_string,"","");
//		System.out.println(sd.toString());
//
//
//		String entity = EntityUtils.toString(sd.getEntity());
//	     //返回的数据类型为json，使用org.json jar包来解析
//	     JSONObject json = new JSONObject(entity);
//	     System.out.println(json.toString());
//
//	}
//
//	public HttpResponse perform_request(String call_type,String url,String body, String atoken) throws Exception{
//	try {
//		String charset = "UTF-8";
//	     /* for(Map.Entry<String, String> entry: headers.entrySet()) {
//	        reqSpec.header(entry.getKey(), entry.getValue());
//	      }
//
//	      for(Map.Entry<String, String> entry: cookie_list.entrySet()) {
//	        reqSpec.cookie(entry.getKey(), entry.getValue());
//	      }
//	 	*/
//		/*
//		 * 获取cookie
//		HttpPost post = new HttpPost("https://apitest.yinpiao.com/api/v1/login/login");
//		StringEntity params1 =new StringEntity("{\"loginName\":\"18501732337\",\"password\":\"111111\",\"loginType\":\"web\"}");
//		post.addHeader("content-type", "application/json");
//		post.setEntity(params1);
//        HttpResponse response1 = httpClient.execute(post);
//        HttpEntity entity1 = response1.getEntity();
//        CookieStore cookieStore = ((AbstractHttpClient) httpClient).getCookieStore();
//        ((AbstractHttpClient) httpClient).setCookieStore(cookieStore);
//
//        List<Cookie> cookies = ((AbstractHttpClient) httpClient).getCookieStore().getCookies();
//        if (cookies.isEmpty()) {
//            System.out.println("None");
//        } else {
//            for (int i = 0; i < cookies.size(); i++) {
//                System.out.println("- " + cookies.get(i).toString());
//
//            }
//        }
//
//		HttpPost post = new HttpPost("http://prdtadmin.yinpiao.com:8083/api/v1/login/login");
//		StringEntity params1 =new StringEntity("{\"loginName\":\"18501732337\",\"password\":\"111111\",\"loginType\":\"web\"}");
//		post.addHeader("content-type", "application/json");
//		post.setEntity(params1);
//        HttpResponse response1 = httpClient.execute(post);
//        String entity1 = EntityUtils.toString(response1.getEntity(),charset);
//        JSONObject json;
//        json = new JSONObject(entity1);
//		System.out.println("返回的cookie内容:" + json.toString());
//		String grd = json.toString();
//		String NND = grd.substring(grd.indexOf("ticket\":\"")+9, grd.indexOf("\",\"status"));
//		System.out.println(NND);
//         */
//	      switch(call_type) {
//
//	        case "GET": {
//	        	 HttpGet httpGet = new HttpGet(url);
//	        	 httpGet.addHeader("atoken", atoken);
//	        	 response = httpClient.execute(httpGet);
//
//	          break;
//	        }
//	        case "POST": {
//	            StringEntity params =new StringEntity(body);
//	        	HttpPost HttpPost = new HttpPost(url);
//	        	HttpPost.addHeader("atoken", atoken);
//	        	HttpPost.addHeader("content-type", "application/json");
//	        	HttpPost.setEntity(params);
//	        	response=new DefaultHttpClient().execute(HttpPost);
//
//	          break;
//	        }
//	        case "PUT": {
//	        	StringEntity params =new StringEntity(body);
//	        	HttpPut HttpPut = new HttpPut(url);
//	        	HttpPut.addHeader("atoken", atoken);
//	        	HttpPut.addHeader("content-type", "application/json");
//	        	HttpPut.setEntity(params);
//	        	response=new DefaultHttpClient().execute(HttpPut);
//
//	          break;
//	        }
//	        case "DELETE": {
//	        	HttpDelete httpDel = new HttpDelete(url);
//	        	httpDel.addHeader("atoken", atoken);
//	        	 response = httpClient.execute(httpDel);
//
//	          break;
//	        }
//
//	        default: {
//	        	System.out.println("未知类型" + call_type);
//	        	break;
//	        }
//	      }
//
//	    } catch (Exception e) {
//	    	e.printStackTrace();
//	    	System.out.printf("Problem performing request: ", e);
//	    }
//
//	return  response;
//
//	}
	
}
