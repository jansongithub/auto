package yinpiao.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;

public class Readconfig
{
//	public static void main(String[] args) {
//		Readconfig sb = new Readconfig();
//		String sc = sb.readProperty("host");
//		System.out.println(sc);
//
//	  }
//
//	//后期改用hashmap存储
//	public String[][] Reqbody(String Excelpath , int sheetNo){
//		HashMap<String,String> body = new HashMap<String,String>();
//			Readconfig sb = new Readconfig();
//			String[][] sc = sb.getApp(Excelpath,sheetNo);
//
//		return sc;
//	}
//
//
//
//  public String[][] getApp(String Excelpath,int sheetNo)
//  {
//    try
//    {
//      String fileName = Excelpath;
//      File file = new File(fileName);
//      Workbook wb = Workbook.getWorkbook(file);
//      Sheet sheet = wb.getSheet(sheetNo);
//      String[][] ss = new String[sheet.getRows()][sheet.getColumns()];
//      for (int i = 0; i < sheet.getRows(); i++) {
//        for (int j = 0; j < sheet.getColumns(); j++) {
//          Cell cell = sheet.getCell(j, i);
//
//          ss[i][j] = cell.getContents();
//        }
//      }
//     wb.close();
//      return ss;
//
//    } catch (BiffException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//    return null;
//  }
//
//  public  String readProperty(String key) {
//	           Properties prop = new Properties();
//	           try{
//	               //读取属性文件a.properties
//	               InputStream in = new BufferedInputStream (new FileInputStream("src/main/java/api.properties"));
//	               prop.load(in);     ///加载属性列表
//	               in.close();
//	               return prop.getProperty(key);
//
//	           }
//	           catch(Exception e){
//	        	   e.printStackTrace();
//	        	   return null;
//	           }
//	       }

  
}
