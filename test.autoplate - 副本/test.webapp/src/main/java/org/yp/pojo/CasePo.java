package org.yp.pojo;

/**
 * Created by zhanxiaobing on 2016/8/10.
 */

import java.sql.Timestamp;

public class CasePo {
    public long id;
    private String projectname;
    private String Intername;
    private String Casename;
    private String method;
    private String Accept;
    private String ContentType;
    private String host;
    private String URI;
    private String islogin;
    private String loginname;
    private String BeforeSqlType;
    private String BeforeSql;
    private String body;
    private String AfterSQLType;
    private String AfterSQL;
    private String ResultResponseType;
    private String ResultResponse;
    public Timestamp createTime;
    public Timestamp updateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccept() {
        return Accept;
    }

    public void setAccept(String accept) {
        this.Accept = accept;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        this.ContentType = contentType;
    }

    public String getResultResponseType() {
        return ResultResponseType;
    }

    public void setResultResponseType(String resultResponseType) {
        this.ResultResponseType = resultResponseType;
    }

    public String getResultResponse() {
        return ResultResponse;
    }

    public void setResultResponse(String resultResponse) {
        this.ResultResponse = resultResponse;
    }

    public String getAfterSQL() {
        return AfterSQL;
    }

    public void setAfterSQL(String afterSQL) {
        this.AfterSQL = afterSQL;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getIntername() {
        return Intername;
    }

    public void setIntername(String intername) {
        this.Intername = intername;
    }

    public String getCasename() {
        return Casename;
    }

    public void setCasename(String casename) {
        this.Casename = casename;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public String getIslogin() {
        return islogin;
    }

    public void setIslogin(String islogin) {
        this.islogin = islogin;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getBeforeSqlType() {
        return BeforeSqlType;
    }

    public void setBeforeSqlType(String beforeSqlType) {
        this.BeforeSqlType = beforeSqlType;
    }

    public String getBeforeSql() {
        return BeforeSql;
    }

    public void setBeforeSql(String beforeSql) {
        this.BeforeSql = beforeSql;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAfterSQLType() {
        return AfterSQLType;
    }

    public void setAfterSQLType(String afterSQLType) {
        this.AfterSQLType = afterSQLType;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}

