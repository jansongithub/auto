package org.yp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.yp.dao.CaseDao;
import org.yp.pojo.CasePo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by zhanxiaobing on 2016/8/11.
 */


public class CaseSearchController {

    private CaseDao caseDao;

    public CaseDao getCaseDao() {
        return caseDao;
    }

    public void setCaseDao(CaseDao caseDao) {
        this.caseDao = caseDao;
    }
    //要加构造函数
    public CaseSearchController(CaseDao caseDao) {
        this.caseDao = caseDao;
    }

//    private String viewpage;
//
//        public String getViewpage() {
//            return viewpage;
//        }
//
//        public void setViewpage(String viewpage) {
//            this.viewpage = viewpage;
//        }
//
//    @RequestMapping("/searchcase.do")
//        protected ModelAndView onSubmit(HttpServletRequest request,
//                                        HttpServletResponse response, Object command, BindException errors)
//                throws Exception {
//            CaseDao tmp = (CaseDao) command;
//            Collection<CasePo> list = caseDao.getTestcase();
//            List<CasePo> testcase = new ArrayList<CasePo>();
//            CasePo casePo;
//            for (CasePo userPO : list) {
//                casePo = new CasePo();
//                casePo.setId(userPO.getId());
//                casePo.setProjectname(userPO.getProjectname());
//                casePo.setIntername(userPO.getIntername());
//                casePo.setHost(userPO.getHost());
//                casePo.setURI(userPO.getURI());
//                testcase.add(casePo);
//            }
//            Map mp = new HashMap();
//            mp.put("list", testcase);
////            return new ModelAndView(getViewpage(), mp);
//        return new ModelAndView("redirect:/jsp/home.jsp", mp);
//        }


}
