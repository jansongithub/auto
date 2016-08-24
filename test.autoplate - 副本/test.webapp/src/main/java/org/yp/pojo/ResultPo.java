package org.yp.pojo;

import java.sql.Timestamp;

/**
 * Created by zhanxiaobing on 2016/8/21.
 */
public class ResultPo {

    public long id;
    private long testplan_id;
    private long testcase_id;
    private String Result_Status;
    private String Result_Response;
    public Timestamp createTime;
    public Timestamp updateTime;

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTestplan_id() {
        return testplan_id;
    }

    public void setTestplan_id(long testplan_id) {
        this.testplan_id = testplan_id;
    }

    public long getTestcase_id() {
        return testcase_id;
    }

    public void setTestcase_id(long testcase_id) {
        this.testcase_id = testcase_id;
    }

    public String getResult_Status() {
        return Result_Status;
    }

    public void setResult_Status(String result_Status) {
        Result_Status = result_Status;
    }

    public String getResult_Response() {
        return Result_Response;
    }

    public void setResult_Response(String result_Response) {
        Result_Response = result_Response;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
