<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'problem_detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <font>问题详情</font><br>
    <div>题目：</div>
    <div><s:property value="problem.title"/></div>
    <div>问题描述：</div>
    <div><s:property value="problem.description"/></div>
    <div>选项：</div>
    <div>
    	<%char a='A'; %>
    	<s:iterator var="p" value="problem.selections">
    		<%=a %>.<s:property value="#p"/>
    		<br>
    		<%a++; %>
    	</s:iterator>
    </div>
    <div>答案：</div>
    <s:property value="problem.answer"/>
    <div>出题人：</div>
    <s:property value="problem.teacher.name"/>
  </body>
</html>
