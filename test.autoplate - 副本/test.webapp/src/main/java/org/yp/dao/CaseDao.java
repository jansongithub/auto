package org.yp.dao;

/**
 * Created by zhanxiaobing on 2016/8/10.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yp.dao.daointerface.IActivityProcedureDao;
import org.yp.pojo.CasePo;
import org.yp.pojo.ResultPo;

import javax.sql.DataSource;

@Service
public class CaseDao extends JdbcDaoSupport implements IActivityProcedureDao {

    /**
     * 数据源
     */
    // private DataSource dataSource;

    /**
     * spring提供的jdbc操作辅助类
     */
//    private JdbcTemplate jdbcTemplate;
//
//    // 设置数据源
//        public void setDataSource(DataSource dataSource) {
//            this.jdbcTemplate = new JdbcTemplate(dataSource);
//        }
    // Casepo对象
    private static final class UserMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            CasePo testcase = new CasePo();
            testcase.setId(rs.getInt("id"));
            testcase.setProjectname(rs.getString("projectName"));
            testcase.setIntername(rs.getString("apiName"));
            testcase.setHost(rs.getString("host"));
            testcase.setURI(rs.getString("call_suff"));
            testcase.setCasename(rs.getString("testcaseName"));
            testcase.setMethod(rs.getString("call_type"));
            testcase.setAccept(rs.getString("Accept"));
            testcase.setContentType(rs.getString("Content_Type"));
            testcase.setIslogin(rs.getString("IsLogin"));
            testcase.setLoginname(rs.getString("user"));
            testcase.setBeforeSqlType(rs.getString("BeforeSqlType"));
            testcase.setBeforeSql(rs.getString("BeforeSql"));
            testcase.setBody(rs.getString("Body"));
            testcase.setAfterSQLType(rs.getString("AfterSqlType"));
            testcase.setAfterSQL(rs.getString("AfterSQL"));
            testcase.setResultResponseType(rs.getString("ResultResponseType"));
            testcase.setResultResponse(rs.getString("ResultResponse"));
            return testcase;
        }
    }
    //ResultPo对象
    private static final class ResultPoMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            ResultPo resultPo = new ResultPo();
            resultPo.setTestplan_id(rs.getLong("testplan_id"));
            resultPo.setTestcase_id(rs.getLong("testcase_id"));
            resultPo.setResult_Status(rs.getString("Result_Status"));
            resultPo.setResult_Response(rs.getString("Result_Response"));
            return resultPo;
        }
    }


    ;
    //新增用例
    public int save(CasePo model) {
        String BeforeSql ;
        String AfterSQL ;
        if (model.getBeforeSql().length() > 0) {
            BeforeSql = model.getBeforeSql();
        }else {
            BeforeSql = null;
        }
        if (model.getAfterSQL().length() > 0) {
            AfterSQL = model.getAfterSQL();
        }else {
            AfterSQL = null;
        }
        return getJdbcTemplate().update("INSERT into testcase(apiName,testcaseName,projectName,call_type,host," +
                        "call_suff,Accept,Content_Type,IsLogin,user,BeforeSqlType,BeforeSql,Body,AfterSqlType,AfterSQL," +
                        "ResultResponseType,ResultResponse) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                model.getIntername(), model.getCasename(), model.getProjectname(), model.getMethod(), model.getHost(), model.getURI(), model.getAccept(), model.getContentType(),
                model.getIslogin(), model.getLoginname(), model.getBeforeSqlType(), BeforeSql, model.getBody(), model.getAfterSQLType(), AfterSQL,
                model.getResultResponseType(), model.getResultResponse());
    }

    //编辑用例
    public void update(CasePo model) {
        String BeforeSql ;
        String AfterSQL ;
        if (model.getBeforeSql().length() > 0) {
            BeforeSql = model.getBeforeSql();
        }else {
            BeforeSql = null;
        }
        if (model.getAfterSQL().length() > 0) {
            AfterSQL = model.getAfterSQL();
        }else {
            AfterSQL = null;
        }
        getJdbcTemplate().update("update testcase set apiName=?,testcaseName=?,projectName=?,call_type=?,host=?,call_suff=?,Accept=?,Content_Type=?,IsLogin=?,user=?,BeforeSqlType=?,BeforeSql=?,Body=?,AfterSqlType=?,AfterSQL=?,ResultResponseType=?,ResultResponse=? where id=?",
                new Object[]{ model.getIntername(), model.getCasename(), model.getProjectname(), model.getMethod(), model.getHost(), model.getURI(), model.getAccept(), model.getContentType(),
                        model.getIslogin(), model.getLoginname(), model.getBeforeSqlType(), BeforeSql, model.getBody(), model.getAfterSQLType(), AfterSQL,
                        model.getResultResponseType(), model.getResultResponse(),model.getId()}
//                new int[]{
//                        java.sql.Types.VARCHAR, java.sql.Types.INTEGER,
//                        java.sql.Types.VARCHAR, java.sql.Types.INTEGER}
        );

    }
    //查询
    @SuppressWarnings("unchecked")
    public List<CasePo> getTestcase() {

        String sql = "select * from testcase t";
        return super.getJdbcTemplate().query(sql, new RowMapper() {

            public Object mapRow(ResultSet rs, int num) throws SQLException {
                CasePo testcase = new CasePo();
                testcase.setId(rs.getInt("id"));
                testcase.setProjectname(rs.getString("projectName"));
                testcase.setIntername(rs.getString("apiName"));
                testcase.setHost(rs.getString("host"));
                testcase.setURI(rs.getString("call_suff"));
                testcase.setCasename(rs.getString("testcaseName"));
                testcase.setMethod(rs.getString("call_type"));
                testcase.setAccept(rs.getString("Accept"));
                testcase.setContentType(rs.getString("Content_Type"));
                testcase.setIslogin(rs.getString("IsLogin"));
                testcase.setLoginname(rs.getString("user"));
                testcase.setBeforeSqlType(rs.getString("BeforeSqlType"));
                testcase.setBeforeSql(rs.getString("BeforeSql"));
                testcase.setBody(rs.getString("Body"));
                testcase.setAfterSQLType(rs.getString("AfterSqlType"));
                testcase.setAfterSQL(rs.getString("AfterSQL"));
                testcase.setResultResponseType(rs.getString("ResultResponseType"));
                testcase.setResultResponse(rs.getString("ResultResponse"));
                return testcase;
            }
        });


    }

    public void delete(Integer id) {
        getJdbcTemplate().update("delete from person where id = ?", new Object[]{id},
                new int[]{java.sql.Types.INTEGER});

    }
    //根据id查询用例
    public CasePo getTestcase(Integer id) {
        CasePo model = (CasePo) getJdbcTemplate().query(
                "select id,apiName,testcaseName,projectName,call_type,host,call_suff,Accept,Content_Type,IsLogin,user,BeforeSqlType,BeforeSql,Body,AfterSqlType,AfterSQL,ResultResponseType,ResultResponse from apitest.testcase where id=?",
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER}, new UserMapper());
        return model;

    }

    //根据id执行用例
    public List<CasePo> doTestcase(List<Integer> caseids) {

        //去掉list的中括号
        String s = Pattern.compile("\\b([\\w\\W])\\b").matcher(caseids.toString().substring(1,caseids.toString().length()-1)).replaceAll("'$1'");

        //拼接SQL
        String sql = "select ID,testcaseName,call_type,host,call_suff,Accept,Content_Type,IsLogin,user,BeforeSqlType," +
                "BeforeSql,Body,AfterSqlType,AfterSQL,ResultResponseType,ResultResponse from apitest.testcase where id in (" + s + ")";

        return super.getJdbcTemplate().query(sql, new RowMapper() {

            public Object mapRow(ResultSet rs, int num) throws SQLException {
                CasePo testcase = new CasePo();
                testcase.setId(rs.getInt("id"));
                testcase.setHost(rs.getString("host"));
                testcase.setURI(rs.getString("call_suff"));
                testcase.setCasename(rs.getString("testcaseName"));
                testcase.setMethod(rs.getString("call_type"));
                testcase.setAccept(rs.getString("Accept"));
                testcase.setContentType(rs.getString("Content_Type"));
                testcase.setIslogin(rs.getString("IsLogin"));
                testcase.setLoginname(rs.getString("user"));
                testcase.setBeforeSqlType(rs.getString("BeforeSqlType"));
                testcase.setBeforeSql(rs.getString("BeforeSql"));
                testcase.setBody(rs.getString("Body"));
                testcase.setAfterSQLType(rs.getString("AfterSqlType"));
                testcase.setAfterSQL(rs.getString("AfterSQL"));
                testcase.setResultResponseType(rs.getString("ResultResponseType"));
                testcase.setResultResponse(rs.getString("ResultResponse"));
                return testcase;
            }
        });

    }

    public int saveCaseDoResult(long  testplan_id, long  testcase_id, String Result_Status,String Result_Response) {

        return getJdbcTemplate().update("replace into apitest.test_result(testplan_id,testcase_id,Result_Status,Result_Response) VALUES (?,?,?,?)",
                testplan_id, testcase_id, Result_Status, Result_Response);
    }
}