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
    
    <title>My JSP 'check_score.jsp' starting page</title>
    
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
    	<table>
    		<tr>
    			<td>考试编号</td>
    			<td>考试名称</td>
    			<td>监考老师</td>
    			<td>操作</td>
    		</tr>
    		<s:iterator var="p" value="Exams">
    			<tr>
    				<td><s:property value="#p.id"/></td>
    				<td><s:property value="#p.name"/></td>
    				<td><s:property value="#p.teacher.name"/></td>
    					<td><a href="${pageContext.request.contextPath }/teacher/exam_score?examID=<s:property value="#p.id"/>">查看成绩</a></td>
    			</tr>
    		</s:iterator>
    	</table>
  </body>
</html>
