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
	    <s:iterator var="p" value="ExamProblems">
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
    <div>
    	<form action="${pageContext.request.contextPath }/teacher/add_problem_to_exam" method="post">
    		<input name="examID" type="hidden" value="<s:property value="examID"/>">
    		<div>题目编号：</div>
    		<div><input name="problemID" type="text"/></div>
    		<div>分值：</div>
    		<div><input name="value" type="text"/></div>	
    		<div><input type="submit" value="添加"/></div>
    		
    	</form>
    	<div></div>
    </div>
    </div>
  </body>
</html>
