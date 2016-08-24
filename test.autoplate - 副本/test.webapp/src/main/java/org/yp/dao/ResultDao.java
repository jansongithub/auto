package org.yp.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.yp.dao.daointerface.ResultProcedureDao;


/**
 * Created by zhanxiaobing on 2016/8/21.
 */
@Service
public class ResultDao extends JdbcDaoSupport implements ResultProcedureDao {



    //新增测试执行结果
    public int saveCaseDoResult(long  testplan_id, long  testcase_id, String Result_Status,String Result_Response) {

        return getJdbcTemplate().update("INSERT into apitest.test_result(testplan_id,testcase_id,Result_Status,Result_Response) VALUES (?,?,?,?)",
                testplan_id, testcase_id, Result_Status, Result_Response);
    }

//    //新增测试执行结果
//    public int saveCaseDoResult(CasePo casePo,ResultPo resultPo) {
//        long  testplan_id ;
//        long  testcase_id ;
//        String Result_Status;
//        String Result_Response;
//        testplan_id = resultPo.getTestplan_id();
//        testcase_id = casePo.getId();
//        Result_Status = resultPo.getResult_Status();
//        Result_Response = resultPo.getResult_Response();
//
//        return super.getJdbcTemplate().update("INSERT into apitest.test_result(testplan_id,testcase_id,Result_Status,Result_Response) VALUES (?,?,?,?);",
//                testplan_id, testcase_id, Result_Status, Result_Response);
//    }
}
