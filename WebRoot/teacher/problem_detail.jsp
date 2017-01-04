<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
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
  <style>
  	.padding-body{
  		padding:10px;
  		margin:20px;
  	}
  	.padding-panel{
  		
  		margin:10px;
  	}
  </style>
  <body>
  	  <h1 class="text-center page-header"><s:property value="problem.title"/></h1>
	  <div class="padding-body">
	  	
	    <div></div>
	    <div><font size="6px">问题描述：</font></div>
	    <div class="panel panel-default padding-panel" >
	    	<div class="padding-body"><font size="4px" ><s:property value="problem.description"/></font></div>
	    </div>
	    <div><font size="6px">选项：</font></div>
	    <div class="panel panel-default padding-panel">
	    	<div class="padding-body">
		    	<font size="4px">
		    	<%char a='A'; %>
		    	<s:iterator var="p" value="problem.selections">
		    		<%=a %>.<s:property value="#p"/>
		    		<br>
		    		<%a++; %>
		    	</s:iterator>
		    	</font>
	    	</div>
	    </div>
	    <div><font size="6px">答案：</font></div>
	    <div>
	    	<div class="panel panel-default padding-panel">
	    		<div class="padding-body"><font size="4px"><s:property value="problem.answer"/></font></div>
	    	</div>
	    </div>
	    <div><font size="6px">出题人：</font></div>
	    <div class="panel panel-default padding-panel">
	    	<div class="padding-body"><s:property value="problem.teacher.name"/></div>
	    </div>
	  </div>
  </body>
</html>
