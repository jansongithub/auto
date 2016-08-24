package org.yp.controller;


import org.springframework.stereotype.Controller;
import org.yp.dao.ResultDao;


import java.net.SocketException;

/**
 * Created by zhanxiaobing on 2016/8/21.
 */
@Controller
public class ResultController {

    private ResultDao resultDao;

    public ResultDao getResultDao() {
        return resultDao;
    }

    public void setResultDao(ResultDao resultDao) {
        this.resultDao = resultDao;
    }
    //要加构造函数
    public ResultController(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    public void testJDBCDaoInsert(long  testplan_id, long  testcase_id, String Result_Status,String Result_Response){



        try {
//            System.out.println("insert rows : " + resultDao.saveCaseDoResult(testplan_id,testcase_id,Result_Status,Result_Response));
            System.out.println("insert rows : " + resultDao.saveCaseDoResult(1, 65, "pass", "resultNote"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

}
