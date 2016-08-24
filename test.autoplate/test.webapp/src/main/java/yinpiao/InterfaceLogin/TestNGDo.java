package yinpiao.InterfaceLogin;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanxiaobing on 2016/8/18.
 */
public class TestNGDo {

    public static void main(String args[]){
        TestNGDo qq = new TestNGDo();
        qq.doCase();

    }

    public  void doCase() {


    TestNG tng = new TestNG();
    TestListenerAdapter rtl = new TestListenerAdapter();
    XmlSuite suite = new XmlSuite();
    suite.setName("TmpSuite");

    XmlTest test = new XmlTest(suite);
    test.setName("TmpTest");
    List<XmlClass> classes = new ArrayList<XmlClass>();
    classes.add(new

    XmlClass("yinpiao.InterfaceLogin.InterfaceLogin")

    );
    test.setXmlClasses(classes);
    List<XmlSuite> suites = new ArrayList<XmlSuite>();
    suites.add(suite);
    tng.setXmlSuites(suites);
//        XmlSuite xs = new XmlSuite();
//        Parser parser = new Parser("G:/workspaces/test.autoplate/test.webapp/src/main/resources/testNG/TestNG.xml");
//        List<XmlSuite> suites = new ArrayList<XmlSuite>();
//        try {
//            suites = parser.parseToList();
//        } catch (ParserConfigurationException e) {
//// TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (SAXException e) {
//// TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//// TODO Auto-generated catch block
//            e.printStackTrace();
//        };
//        tng.setXmlSuites(suites);

    //   tng.setTestClasses(new Class[]{yinpiao.InterfaceLogin.InterfaceLogin.class});//这里可以加多个类。
    tng.addListener(rtl);

    tng.run();
}




}
