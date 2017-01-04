<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'student_manage.jsp' starting page</title>
    
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
    <div><font>所有学生列表</font></div>
    <div>
    	<table>
    			<tr>
    				<td>编号</td>
    				<td>用户名</td>
    				<td>真实姓名</td>
    				<td>班级</td>
    			</tr>
    		<s:iterator var="p" value="student_list">
	    		<tr>
	    			<td><s:property value="#p.id"/></td>
	    			<td><s:property value="#p.username"/></td>
	    			<td><s:property value="#p.name"/></td>
	    			<td><s:property value="#p.class_"/></td>
	    			<!-- <td><a href="${pageContext.request.contextPath }/admin/delete_student?studentID=<s:property value="#p.id"/>">删除用户</a></td> -->
	    		</tr>
	    	</s:iterator>
    	</table>
    </div>
  </body>
</html>
