package yinpiao.common;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.json.JSONObject;
//import org.skyscreamer.jsonassert.JSONCompareResult;

public class DataWriter {
	
//	public static void main(String args[]) throws Exception{
//		// create writable wookbook
//		HSSFSheet outputSheet = null ;
//
//
//		DataWriter sb = new DataWriter();
//		sb.writeData(outputSheet,"1","A","test");
//	}
//
//	public static void writeData(HSSFSheet outputSheet, String entity, String iD, String testCase) throws Exception {
//		 try {
//
//			   Workbook wb
//			    = Workbook.getWorkbook(new File("E:/Interface/test.xls"));
//			   WritableWorkbook workbook = Workbook.createWorkbook(new File("E:/Interface/test1.xls"),wb);
//			   // create writable sheet
//			   WritableSheet sheet = workbook.getSheet("Output");
//
//			   String data[][]={{iD},{testCase},{entity}};
//
//			   for(int i = 0; i < data.length; i++) {
//			    for(int j = 1; j < data[i].length; j++){
//
//			     Label label = new Label(i, j, data[i][j]);
//			     sheet.addCell(label);
//			    }
//			   }
//			   workbook.write();
//			   workbook.close();
//			  } catch (IOException | WriteException e) {
//			   e.printStackTrace();
//			  }
//
//	}
//
//	public static void writeData(HSSFSheet resultSheet, String string,
//			String iD, String testCase, int i) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public static void writeData(HSSFSheet comparsionSheet,
//			JSONCompareResult result, String iD, String testCase) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public static void writeData(HSSFSheet outputSheet) {
//		// TODO Auto-generated method stub
//
//	}

}
