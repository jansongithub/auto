<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="org.yp.test.WebHome" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>首页</title>
</head>
<%
    WebHome a=new WebHome();
%>
<script charset="UTF-8"  type="text/javascript"  src="/js/case.js"></script>
<script charset="UTF-8"  type="text/javascript"  src="/js/other/jquery-3.0.0.js"></script>
<script charset="UTF-8"  type="text/javascript"  src="/js/layer/layer.js"></script>

<div id="sysNodeList"  >
<form id="addCase" onsubmit="return tijiao()">
    <div align="left" >项目名称：
        <select name="projectname"  id="projectname" onmouseover="" class="text1">
            <option value="0">请选择</option>
            <option value="<%=a.projectName(0)%>"><%=a.projectName(0)%></option>
            <option value="2"><%=a.projectName(1)%></option>
            <option value="3"><%=a.projectName(2)%></option>
            <option value="4"><%=a.projectName(3)%></option>
        </select>
        <!--<script>frm.balanceWay.value = "<c:out value='${tradeAgreement.balanceWay}'/>" </script>-->
    </div>
    <div align="left" >接口名称：<input type="text" name="Intername" id="Intername" value="" autocomplete="off"> </div>
    <div align="left" >用例名称：<input type="text" name="Casename" id="Casename" value="" autocomplete="off"> </div>
    <div align="left" >请求方法：
        <select name="method"  id="method" onmouseover="" class="text1">
            <option value="GET">请选择</option>
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
            <option value="">请选择</option>
            <option value="Add">Add</option>
            <option value="Delete">Delete</option>
            <option value="Update">Update</option>
            <option value="Search">Search</option>
        </select></div>
    <div align="left" >初始化Sql：<textarea  name="BeforeSql" name="BeforeSql" rows="4" cols="30"> </textarea> </div>
    <div align="left" >请求内容：<textarea  name="body" name="body" rows="4" cols="30"> </textarea> </div>
    <div align="left" >清理测试用例数据：
        <select name="AfterSQLType"  id="AfterSQLType" onmouseover="" class="text1">
            <option value="">请选择</option>
            <option value="Add">Add</option>
            <option value="Delete">Delete</option>
            <option value="Update">Update</option>
            <option value="Search">Search</option>
        </select></div>
    <div align="left" >清理数据Sql：<textarea name="AfterSQL" id="AfterSQL"  rows="4" cols="30"></textarea> </div>
    <div align="left" >结果验证方式：
        <select name="ResultResponseType"  id="ResultResponseType" onmouseover="" class="text1">
            <option value="Contains">Contains</option>
            <option value="NoContains">NoContains</option>
        </select>(Response是否包含)</div>
    <div align="left" >验证Response：<textarea  name="ResultResponse" id="ResultResponse" rows="4" cols="30"></textarea> </div>
    <p style="margin-left:30px;color:red" id="adderrmsg"></p>
    <div align="left" ><input type="submit" id="submit" value="保存" > </div>
</form>
</div>

</body>
</html>