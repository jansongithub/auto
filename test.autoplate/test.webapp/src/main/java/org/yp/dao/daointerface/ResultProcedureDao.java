package org.yp.dao.daointerface;

/**
 * Created by zhanxiaobing on 2016/8/22.
 */
public interface ResultProcedureDao {

    public abstract int saveCaseDoResult(long  testplan_id, long  testcase_id, String Result_Status,String Result_Response);

}
