<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="/menu.jsp" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'exam_score.jsp' starting page</title>
    
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
  .table-padding {
			padding: 10px;
			
		}
  </style>
  
  <body>
    <div>
    	<h1 class="text-center page-header">学生成绩单</h1>
    <div class="table-padding">
    	<table class="table table-striped table-hover">
    		<thead>
    			<td>学生编号</td>
    			<td>学生姓名</td>
    			<td>学生班级</td>
    			<td>成绩</td>
    		</thead>
	    	<s:iterator var="p" value="studentScoreList">
	    		<tr>
	    			<td><s:property value="#p.student.id"/></td>
	    			<td><s:property value="#p.student.name"/></td>
	    			<td><s:property value="#p.student.class_"/></td>
	    			<td><s:property value="#p.score"/></td>
	    		</tr>
	    	</s:iterator>
    	</table>
    </div>
  </body>
</html>
