package org.yp.servlet;

/**
 * Created by zhanxiaobing on 2016/8/4.
 */

import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Saveservlet extends HttpServlet {

//   @Autowired
//   private  ActivityProcedureDaoImpl activityProcedureDaoImpl;
//
//    public ActivityProcedureDaoImpl getActivityProcedureDaoImpl() {
//        return activityProcedureDaoImpl;
//    }
//
//    public void setActivityProcedureDaoImpl(ActivityProcedureDaoImpl activityProcedureDaoImpl) {
//        this.activityProcedureDaoImpl = activityProcedureDaoImpl;
//    }
//
//    protected void service(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        AddCase newAddCase = new AddCase();
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        request.setCharacterEncoding("UTF-8");
//        String projectname = request.getParameter("projectname");
//        String Intername = request.getParameter("Intername");
//        String Casename = request.getParameter("Casename");
//        String method = request.getParameter("method");
//        String host = request.getParameter("host");
//        String URI = request.getParameter("URI");
//        String accept = request.getParameter("accept");
//        String ContentType = request.getParameter("ContentType");
//        String islogin = request.getParameter("islogin");
//        String loginname = request.getParameter("loginname");
//        String ResultResponse = request.getParameter("ResultResponse");
//        String ResultResponseType = request.getParameter("ResultResponseType");
//
//        newAddCase.setIntername(Intername);
//        newAddCase.setCasename(Casename);
//        newAddCase.setProjectname(projectname);
//        newAddCase.setMethod(method);
//        newAddCase.setHost(host);
//        newAddCase.setURI(URI);
//        newAddCase.setAccept(accept);
//        newAddCase.setContentType(ContentType);
//        newAddCase.setIslogin(islogin);
//        newAddCase.setLoginname(loginname);
//        newAddCase.setResultResponseType(ResultResponse);
//        newAddCase.setResultResponse(ResultResponseType);
//
//
//        out.println("<html>");
//        out.println("<body>");
//        out.println("项目名:" + projectname + "<br>");
//        out.println("接口名：" + Intername);
//        out.println("接口名：" + Casename);
//        out.println("接口名：" + method);
//        out.println("接口名：" + host);
//        out.println("接口名：" + URI);
//        out.println("接口名：" + accept);
//        out.println("接口名：" + ContentType);
//        out.println("接口名：" + islogin);
//        out.println("接口名：" + loginname);
//        out.println("接口名：" + ResultResponse);
//        out.println("接口名：" + ResultResponseType);
//        out.println("</body>");
//        out.println("</html>");
//
////        activityProcedureDaoImpl.insert(newAddCase);
//
//    }
}

