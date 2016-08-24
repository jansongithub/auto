package org.yp.controller;

/**
 * Created by zhanxiaobing on 2016/8/10.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.SocketException;
import java.util.*;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.yp.dao.CaseDao;
import org.yp.dao.ResultDao;
import org.yp.pojo.CasePo;

import org.yp.pojo.ResultPo;
import yinpiao.common.EncodingTool;
import yinpiao.testCaseDo.HttpRequestDo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class CaseController {

    public String[][] Caselist;

    private CaseDao caseDao;

    public CaseDao getCaseDao() {
        return caseDao;
    }

    public void setCaseDao(CaseDao caseDao) {
        this.caseDao = caseDao;
    }

    //加构造函数
    public CaseController(CaseDao caseDao) {
        this.caseDao = caseDao;
    }

    EncodingTool encodingTool =  new EncodingTool();

    @RequestMapping("/savecase.do")
    public ModelAndView testJDBCDaoQuery(HttpServletRequest rs) throws InterruptedException, SocketException {

        CasePo testcase = new CasePo();
        testcase.setIntername(rs.getParameter("Intername"));
        testcase.setCasename(rs.getParameter("Casename"));
        testcase.setProjectname(rs.getParameter("projectname"));
        testcase.setMethod(rs.getParameter("method"));
        testcase.setHost(rs.getParameter("host"));
        testcase.setURI(rs.getParameter("URI"));
        testcase.setAccept(rs.getParameter("Accept"));
        testcase.setContentType(rs.getParameter("ContentType"));
        testcase.setIslogin(rs.getParameter("islogin"));
        testcase.setLoginname(rs.getParameter("loginname"));
        testcase.setResultResponseType(rs.getParameter("ResultResponseType"));
        testcase.setResultResponse(rs.getParameter("ResultResponse"));
        testcase.setBody(rs.getParameter("body"));
        testcase.setBeforeSqlType(rs.getParameter("BeforeSqlType"));
        testcase.setBeforeSql(rs.getParameter("BeforeSql"));
        testcase.setAfterSQLType(rs.getParameter("AfterSQLType"));
        testcase.setAfterSQL(rs.getParameter("AfterSQL"));

        try {
            System.out.println("insert rows : " + caseDao.save(testcase));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new ModelAndView("redirect:/jsp/home.jsp");

    }

    @RequestMapping("/editcase.do")
    public ModelAndView testJDBCDaoEdit(HttpServletRequest rs) throws InterruptedException, SocketException {

        String id = rs.getParameter("caseNo");

        CasePo testcase = new CasePo();
        testcase.setId(Long.parseLong(id) );
        testcase.setIntername(rs.getParameter("Intername"));
        testcase.setCasename(rs.getParameter("Casename"));
        testcase.setProjectname(rs.getParameter("projectname"));
        testcase.setMethod(rs.getParameter("method"));
        testcase.setHost(rs.getParameter("host"));
        testcase.setURI(rs.getParameter("URI"));
        testcase.setAccept(rs.getParameter("Accept"));
        testcase.setContentType(rs.getParameter("ContentType"));
        testcase.setIslogin(rs.getParameter("islogin"));
        testcase.setLoginname(rs.getParameter("loginname"));
        testcase.setResultResponseType(rs.getParameter("ResultResponseType"));
        testcase.setResultResponse(rs.getParameter("ResultResponse"));
        testcase.setBody(rs.getParameter("body"));
        testcase.setBeforeSqlType(rs.getParameter("BeforeSqlType"));
        testcase.setBeforeSql(rs.getParameter("BeforeSql"));
        testcase.setAfterSQLType(rs.getParameter("AfterSQLType"));
        testcase.setAfterSQL(rs.getParameter("AfterSQL"));

        try {
            caseDao.update(testcase);
          //  System.out.println("insert rows : " + caseDao.update(testcase););
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new ModelAndView("redirect:/jsp/home.jsp");

    }
//
//    @RequestMapping("/searchcaseid.do")
//    protected void searchCaseId(HttpServletRequest request,
//                            HttpServletResponse response, ModelMap modelMap)
//            throws Exception {
//        CasePo casePo = caseDao.getTestcase(16);
//
//        JSONArray jsonArray = JSONArray.fromObject(casePo);
//        JSONObject jsonObj4  = new JSONObject();
//        jsonObj4.element("aaData", jsonArray);
//        System.out.println("jsonObj4:"+jsonObj4);
//        response.getWriter().write(jsonObj4.toString());
//    }
//
    @RequestMapping("/searchcase.do")
    protected void onSubmit(HttpServletRequest request,
                            HttpServletResponse response, ModelMap modelMap)
            throws Exception {
        List<CasePo> list = caseDao.getTestcase();
        List<CasePo> testcase = new ArrayList<CasePo>();
        CasePo casePo;
        for (CasePo userPO : list) {
            casePo = new CasePo();
            casePo.setId(userPO.getId());
            casePo.setProjectname(userPO.getProjectname());
            casePo.setIntername(userPO.getIntername());
            casePo.setHost(userPO.getHost());
            casePo.setURI(userPO.getURI());
            testcase.add(casePo);
        }
    //    Map mp = new HashMap();
        // mp.addAttribute("list", list);
  //      modelMap.put("list", list);
 //       request.setAttribute("list", list);
//            return new ModelAndView(getViewpage(), mp);
//        return new ModelAndView("/jsp/home.jsp",mp);


        JSONArray jsonArray = JSONArray.fromObject(list);
        JSONObject jsonObj4  = new JSONObject();
        jsonObj4.element("aaData", jsonArray);
       // System.out.println("jsonObj4:"+jsonObj4);

       // response.setHeader("Content-type", "text/html;charset=UTF-8");
        encodingTool.getWriter(response).write(jsonObj4.toString());
        //response.getWriter().write(jsonObj4.toString());
    }


    @RequestMapping("/docaseid.do")
    protected void doCaseId(HttpServletRequest request,
                                HttpServletResponse response, ModelMap modelMap)
            throws Exception {


        //List<Integer> caseid = new  ArrayList<Integer>();
        //String id = request.getParameter("id");

//        try {
//            int a = Integer.parseInt(id);
//            caseid.add(a);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
        //获取前台传来的key为id的数据
        String [] caseid = request.getParameterValues("id");

        StringBuffer stringBuffer = new StringBuffer();

        for(int i = 0; i < caseid.length; i++){
            stringBuffer. append(caseid[i]);
        }

        String newStr = stringBuffer.toString();

        String[] array = newStr.split(",");
        List<String> caseList = new ArrayList<String>();
        for (String str : array)
        {
            caseList.add(str);
        }

//        List<String> caseList = new ArrayList<String>();
//        Collections.addAll(caseList, caseid);

//        System.out.println("caseid:" + caseid[0]);
//        System.out.println("caseList:"+caseList.get(0));

        List<Integer> caseidlist = new ArrayList<Integer>();

        for(int i=0;i<caseList.size();i++) {
            caseidlist.add(Integer.parseInt(caseList.get(i)));
        }

//  8.23 22:53      int[] ia=new int[caseid.length];
//
//        for(int i=0;i<caseid.length;i++) {
//            ia[i] = Integer.parseInt(caseid[i]);
//        }
//
//        List<Integer> caseidlist = new ArrayList<Integer>(ia.length);
//
//        for(Integer uid: ia){
//
//            caseidlist.add(uid);
//
//        }

//        List<Integer> piDigits = new  ArrayList<Integer>();
//
//        for(int i=65;i<67;i++){
//            piDigits.add(i);
//        }
        //数据库查询id为前台传来的所有用例
        List<CasePo> list = caseDao.doTestcase(caseidlist);


        List<CasePo> testcase = new ArrayList<CasePo>();
        CasePo casePo;
        for (CasePo userPO : list) {
            casePo = new CasePo();
            casePo.setId(userPO.getId());
            casePo.setProjectname(userPO.getProjectname());
            casePo.setIntername(userPO.getIntername());
            casePo.setHost(userPO.getHost());
            casePo.setURI(userPO.getURI());
            testcase.add(casePo);
        }

        JSONArray jsonArray = JSONArray.fromObject(list);
        JSONObject jsonObj4  = new JSONObject();
    //    jsonObj4.element(jsonArray);
         System.out.println("jsonObj4:" + jsonArray.toString());
        encodingTool.getWriter(response).write(jsonArray.toString());
      //  return jsonArray;
        //String[][] array1 = {{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"},{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"}};
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("id","1");
//        jsonObject.put("user","1");

        HttpRequestDo httpRequestDo = new HttpRequestDo();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            ResultPo resultPo = new ResultPo();
            resultPo = httpRequestDo.apiTest(jsonObject);
            caseDao.saveCaseDoResult(resultPo.getTestplan_id(), resultPo.getTestcase_id(), resultPo.getResult_Status(), resultPo.getResult_Response());

        }

    }


}