<%--
  Created by IntelliJ IDEA.
  User: zhanxiaobing
  Date: 2016/8/24
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
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
  <title>用例执行</title>
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
<script charset="UTF-8"  type="text/javascript"  src="/js/casedo.js"></script>
<script charset="UTF-8"  type="text/javascript"  src="/js/other/jquery.dataTables.js"></script>
<script charset="UTF-8"  type="text/javascript"  src="/js/layer/layer.js"></script>
<script charset="UTF-8"  type="text/javascript"  src="/js/other/jquery-ui.js"></script>

<%--导航栏--%>
<div id="nav">
  <ul id="navMenu">
    <li><a href='/jsp/home.jsp' target="_blank">主页</a></li>
    <li><a href='' rel='dropmenu1' target="_blank">测试计划</a></li>
    <li><a href='/jsp/result.jsp' target="_blank">测试报告</a></li>
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

<%--<div align="left" id="docasetb" ><input type="button" id="doCaseform" value="执行用例" onclick="doallCase()"  </div>--%>

<div  id="resultList">
  <form id="resultsearch" name="resultsearch" method="post" modelAttribute="resultsearch">
    <table id="CaseDo" class="display" width="100%">
      <thead>
      <tr>
        <%--<th>--%>
          <%--<input type="checkbox" id="checkbox_docaseid_all" class="checkall">--%>
        <%--</th>--%>
        <th>用例编号</th>
        <th>项目名</th>
        <th>接口名</th>
        <th>HOST</th>
        <th>URI</th>
        <th>执行结果</th>
        <th>执行用例</th>
      </tr>
      </thead>
      <tfoot>
      <tr>
        <%--<th><input type="checkbox"  style="display: none" name="" id="" value=""></th>--%>
        <th>用例编号</th>
        <th>项目名</th>
        <th>接口名</th>
        <th>HOST</th>
        <th>URI</th>
        <th>执行结果</th>
        <th>执行用例</th>
      </tr>
      </tfoot>
    </table>
  </form>
</div>

<body>
</body>
</html>
