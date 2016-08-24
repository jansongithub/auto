<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="org.yp.test.WebHome" %>
<%@ page import="org.yp.controller.CaseController" %>
<%@ page import="org.yp.pojo.CasePo" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>首页</title>
</head>
<%
  WebHome a=new WebHome();
%>
<!-- basic styles -->
<%--<link href="/css/bootstrap.min.css" rel="stylesheet" />--%>
<%--<link href="/css/bootstrap-responsive.min.css" rel="stylesheet" />--%>
<%--<link rel="stylesheet" href="/css/font-awesome.min.css" />--%>
<!-- page specific plugin styles -->
<!-- 下拉框-->
<%--<link rel="stylesheet" href="/css/chosen.css" />--%>
<!-- ace styles -->
<%--<link rel="stylesheet" href="/css/ace.min.css" />--%>
<%--<link rel="stylesheet" href="/css/ace-responsive.min.css" />--%>
<%--<link rel="stylesheet" href="/css/ace-skins.min.css" />--%>
<%--<link rel="stylesheet" href="/css/datepicker.css" /><!-- 日期框 -->--%>
<link rel="stylesheet" href="/css/other/jquery.dataTables.css" />
<link rel="stylesheet" href="/css/other/dataTables.bootstrap.css" />
<link rel="stylesheet" href="/css/other/dataTables.foundation.css" />
<link rel="stylesheet" href="/css/other/dataTables.jqueryui.css" />
<link rel="stylesheet" href="/css/other/jquery.dataTables_themeroller.css" />
<link rel="stylesheet" href="/css/other/dataTables.uikit.css" />
<link rel="stylesheet" href="/css/other/dataTables.semanticui.css" />
<link rel="stylesheet" type="text/css" href="/css/daohanglan.css">
<%--<link rel="stylesheet" href="/css/other/dataTables.material.css" />--%>

<script charset="UTF-8"  type="text/javascript"  src="/js/other/jquery-3.0.0.js"></script>
<script charset="UTF-8"  type="text/javascript"  src="/js/case.js"></script>
<script charset="UTF-8"  type="text/javascript"  src="/js/other/jquery.dataTables.js"></script>
<script charset="UTF-8"  type="text/javascript"  src="/js/layer/layer.js"></script>
<script charset="UTF-8"  type="text/javascript"  src="/js/other/jquery-ui.js"></script>

<%--导航栏--%>
<div id="nav">
    <ul id="navMenu">
        <li><a href='/jsp/home.jsp' target="_blank">主页</a></li>
        <li><a href='' rel='dropmenu1' target="_blank">测试计划</a></li>
        <li><a href='' target="_blank">测试报告</a></li>
        <li><a class="current" href=''  rel='dropmenu2' target="_blank">环境配置</a></li>
    </ul>
</div>

<script type='text/javascript' src='/js/daohanglan.js'></script>
<ul id="dropmenu1" class="dropMenu">
    <li><a href="" target="_blank">测试计划</a></li>
    <li><a href="/jsp/caseDo.jsp" target="_blank">测试执行</a></li>
    <li><a href="" target="_blank">定时任务</a></li>

</ul>
<ul id="dropmenu2" class="dropMenu">
    <li><a href="" target="_blank">测试用例</a></li>
    <li><a href="" target="_blank">项目配置</a></li>
    <li><a href="" target="_blank">环境管理</a></li>
</ul>
<script type="text/javascript">cssdropdown.startchrome("navMenu")</script>



<div align="left" ><input type="button" id="addCaseform" value="新增用例" onclick="addCasef()"> </div>
<div  id="caselist">
    <form id="caselistsearch" name="caselistsearch" method="post" modelAttribute="caselistsearch">
        <%--<table>--%>
            <%--<tbody>--%>
             <%--<tr>--%>
                 <%--<td>--%>
                     <%--<span class="input-icon">--%>
                         <%--<input id="apiuri" type="text" placeholder="输入接口URI" style="width:100px;" value="" name="apiuri" autocomplete="off">--%>
                         <%--<i id="apiuri-icon" class="icon-search"> </i>--%>
                     <%--</span>--%>
                 <%--</td>--%>
                 <%--<td>--%>
                         <%--<input id="projectname" class="span10 date-picker" type="text" style="width:130px;" placeholder="输入接口项目名" value="" name="projectname" autocomplete="off">--%>
                         <%--<i id="projectname-icon" class="icon-search"> </i>--%>
                 <%--</td>--%>
                 <%--<td>--%>
                     <%--<input id="createtime" class="span10 date-picker" type="text" placeholder="开始日期"  style="width:88px;" data-date-format="yyyy-mm-dd" value="" name="createtime">--%>
                 <%--</td>--%>
                 <%--<td>--%>
                     <%--<input id="endtime" class="span10 date-picker" type="text" placeholder="结束日期"  style="width:88px;" data-date-format="yyyy-mm-dd" value="" name="endtime">--%>
                 <%--</td>--%>
                 <%--<td style="vertical-align: top">--%>
                    <%--&lt;%&ndash;<button class="btn btn-mini btn-light" value="查询" onclick="serarchcase();">&ndash;%&gt;--%>
                       <%--&lt;%&ndash;<i id="casesearchbutton" class="icon-search"></i>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                        <%--<input type="button" id="casesearchbutton" value="查询" onclick="serarchcase()">--%>
                 <%--</td>--%>
             <%--</tr>--%>
            <%--</tbody>--%>
        <%--</table>--%>
        <table id="example2" class="display" width="100%">
            <thead>
            <tr>
                <th>
                    <input type="checkbox" id="checkbox_id_all">
                </th>
                <th>用例编号</th>
                <th>项目名</th>
                <th>接口名</th>
                <th>HOST</th>
                <th>URI</th>
                <th>编辑</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <th><input type="checkbox"  style="display: none" name="" id="" value=""></th>
                <th>用例编号</th>
                <th>项目名</th>
                <th>接口名</th>
                <th>HOST</th>
                <th>URI</th>
                <th>编辑</th>
            </tr>
            </tfoot>
        </table>
    </form>
</div>

<body>
<%--编辑用例--%>
<div id="editCaseList" style="display: none">
    <form id="editCase" onsubmit="editCasef()">
        <div align="left">用例编号：<input id="caseNo" name="caseNo"></div>
        <div align="left" >项目名称：
            <select name="projectname"  id="projectname" onmouseover="" class="text1">
                <option value="0">请选择</option>
                <option value="<%=a.projectName(0)%>"><%=a.projectName(0)%></option>
                <option value="<%=a.projectName(1)%>"><%=a.projectName(1)%></option>
                <option value="<%=a.projectName(2)%>"><%=a.projectName(2)%></option>
                <option value="<%=a.projectName(3)%>"><%=a.projectName(3)%></option>
            </select>
            <!--<script>frm.balanceWay.value = "<c:out value='${tradeAgreement.balanceWay}'/>" </script>-->
        </div>
        <div align="left" >接口名称：<input type="text" name="Intername" id="Intername" value="" autocomplete="off"> </div>
        <div align="left" >用例名称：<input type="text" name="Casename" id="Casename" value="" autocomplete="off"> </div>
        <div align="left" >请求方法：
            <select name="method"  id="method" onmouseover="" class="text1">
                <option value="0">请选择</option>
                <option value="GET">GET</option>
                <option value="POST">POST</option>
                <option value="PUT">PUT</option>
                <option value="DELETE">DELETE</option>
            </select></div>
        <div align="left" >Accept：
            <select name="Accept"  id="Accept" onmouseover="" class="text1">
                <option value="application/json">application/json</option>
            </select></div>
        <div align="left" >Content-Type：
            <select name="ContentType"  id="ContentType" onmouseover="" class="text1">
                <option value="application/json">application/json</option>
            </select></div>
        <div align="left" >HOST：<input type="text" name="host"  id="host" value="" autocomplete="off"> </div>
        <div align="left" >URI地址：<input type="text" name="URI" id="URI" value="" autocomplete="off"> </div>
        <div align="left" >是否登录：<input type="checkbox" name="islogin" id="islogin" value="NoLogin"> </div>

        <style type="text/css">
            .text1{width:130px; height:20px}
        </style>
        <div align="left" >登录账户：<textarea  name="loginname" id="loginname" rows="4" cols="30"> </textarea> </div>
        <div align="left" >初始化数据：
            <select name="BeforeSqlType"  id="BeforeSqlType" onmouseover="" class="text1">
                <option value="0">请选择</option>
                <option value="Add">Add</option>
                <option value="Delete">Delete</option>
                <option value="Update">Update</option>
                <option value="Search">Search</option>
            </select></div>
        <div align="left" >初始化Sql：<textarea  name="BeforeSql" name="BeforeSql" rows="4" cols="30"> </textarea> </div>
        <div align="left" >请求内容：<textarea  name="body" name="body" rows="4" cols="30"> </textarea> </div>
        <div align="left" >清理测试用例数据：
            <select name="AfterSQLType"  id="AfterSQLType" onmouseover="" class="text1">
                <option value="0">请选择</option>
                <option value="Add">Add</option>
                <option value="Delete">Delete</option>
                <option value="Update">Update</option>
                <option value="Search">Search</option>
            </select></div>
        <div align="left" >清理数据Sql：<textarea name="AfterSQL" id="AfterSQL"  rows="4" cols="30"></textarea> </div>
        <div align="left" >结果验证方式：
            <select name="ResultResponseType"  id="ResultResponseType" onmouseover="" class="text1">
                <option value="0">Contains</option>
                <option value="1">NoContains</option>
            </select>(Response是否包含)</div>
        <div align="left" >验证Response：<textarea  name="ResultResponse" id="ResultResponse" rows="4" cols="30"></textarea> </div>
        <p style="margin-left:30px;color:red" id="adderrmsg"></p>
        <div align="left" ><input type="submit" id="submit" value="保存" > </div>
    </form>
</div>
</body>
</html>