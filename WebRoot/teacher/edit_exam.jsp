<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_exam.jsp' starting page</title>
    
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
    <div>编辑考试</div>
    <div>当前已有试题:</div>
    <div>
    <table>
	    <s:iterator var="p" value="exam_problem">
	    	<tr>
			   	<td><s:property value="#p.id"/></td>
			   		<td><s:property value="#p.title"/></td>
			   		<td>
			   			<s:if test="#p.type == 0">
			   				单选题
			   			</s:if>
			   			<s:else>
			   				填空题
			   			</s:else>
			   		</td>
			   		<td><s:property value="#p.teacher.name"/></td>
			   		<td><a href="${pageContext.request.contextPath }/teacher/problem_detail?problemID=<s:property value="#p.id"/>">详情</a></td>
	    	<tr>
	    </s:iterator>
    </table>
    </div>
  </body>
</html>
