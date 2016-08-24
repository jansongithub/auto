package yinpiao.common;

import java.io.BufferedReader;   
import java.io.DataOutputStream;   
import java.io.IOException;   
import java.io.InputStreamReader;   
import java.net.HttpURLConnection;   
import java.net.URL;   
import java.net.URLEncoder;

public class HttpRequest {
	public static final String GET_URL = " http://192.168.1.94:8080/admin/trade/restful/main/bill/list?num=1&page=1&status=0";  
    public static final String POST_URL = " http://localhost:8080/demo/  ";   

    public static void readContentFromGet() throws IOException {   

           // ƴ��get�����URL�ִ���ʹ��URLEncoder.encode������Ͳ��ɼ��ַ����б���
          // String getURL = GET_URL + " ?username= " + URLEncoder.encode("fat man", "utf-8");
           String getURL = GET_URL;

           URL getUrl = new URL(getURL);

           // ����ƴ�յ�URL�������ӣ�URL.openConnection()��������� URL�����ͣ����ز�ͬ��URLConnection����Ķ������������ǵ�URL��һ��http�������ʵ���Ϸ��ص���HttpURLConnection
           HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();

           // ����������������ӣ���δ��������
           connection.connect();

           // �������ݵ���������ʹ��Reader��ȡ���ص�����
           BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

           System.out.println(" ============================= ");
           System.out.println(" Contents of get request ");
           System.out.println(" ============================= ");

           String lines;
           while ((lines = reader.readLine()) != null) {
                   System.out.println(lines);
           }

           reader.close();

           // �Ͽ�����
           connection.disconnect();

           System.out.println(" ============================= ");
           System.out.println(" Contents of get request ends ");
           System.out.println(" ============================= ");
    }



    public static void readContentFromPost() throws IOException {

           // Post�����url����get��ͬ���ǲ���Ҫ������
           URL postUrl = new URL(POST_URL);

           // ������
           HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();

           //�򿪶�д���ԣ�Ĭ�Ͼ�Ϊfalse
           connection.setDoOutput(true);
           connection.setDoInput(true);

           // ��������ʽ��Ĭ��ΪGET
           connection.setRequestMethod(" POST ");

           // Post ������ʹ�û���
           connection.setUseCaches(false);

           // URLConnection.setFollowRedirects��static ���������������е�URLConnection����
           // connection.setFollowRedirects(true);

           //URLConnection.setInstanceFollowRedirects �ǳ�Ա�������������ڵ�ǰ����
           connection.setInstanceFollowRedirects(true);

           // �������ӵ�Content-type������Ϊapplication/x- www-form-urlencoded����˼��������urlencoded�������form�������������ǿ��Կ������Ƕ���������ʹ��URLEncoder.encode���б���
           connection.setRequestProperty(" Content-Type ", " application/x-www-form-urlencoded ");

           // ���ӣ���postUrl.openConnection()���˵����ñ���Ҫ�� connect֮ǰ��ɣ�
           // Ҫע�����connection.getOutputStream()�������Ľ��е��� connect()�������������ʡ��
           //connection.connect();
           DataOutputStream out = new DataOutputStream(connection.getOutputStream());

           //����������ʵ��get��URL��'?'��Ĳ����ַ���һ��
           String content = " firstname= "+URLEncoder.encode(" һ������� ", "utf-8");

           // DataOutputStream.writeBytes���ַ����е�16λ�� unicode�ַ���8λ���ַ���ʽд��������
           out.writeBytes(content);   
           out.flush();   
           out.close(); // flush and close   

           BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));   

           String line;   
           System.out.println(" ============================= ");   
           System.out.println(" Contents of post request ");   
           System.out.println(" ============================= ");   

           while ((line = reader.readLine()) != null) {   
                   System.out.println(line);   
           }   

           System.out.println(" ============================= ");   
           System.out.println(" Contents of post request ends ");   
           System.out.println(" ============================= ");   

           reader.close();   
           //connection.disconnect();   
    }   

    public static void main(String[] args) {   

           // TODO Auto-generated method stub   
           try {   
                   readContentFromGet();   
                  // readContentFromPost();   
           } catch (IOException e) {   

                   // TODO Auto-generated catch block   
                   e.printStackTrace();   
           }   
    }   

}
