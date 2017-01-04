<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teacher_manage.jsp' starting page</title>
    
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
   				<td>编号</td>
   				<td>用户名</td>
   				<td>真实姓名</td>
   				<td>密码</td>
   			</tr>
    		<s:iterator var="p" value="teacher_list">
	    		<tr>
	    			<td><s:property value="#p.id"/></td>
	    			<td><s:property value="#p.username"/></td>
	    			<td><s:property value="#p.name"/></td>
	    			<td><s:property value="#p.password"/></td>
	    		</tr>
	    	</s:iterator>
    	</table>
    	<form action="${pageContext.request.contextPath }/admin/add_teacher" method="post">
    		<div>用户名：</div>
    		<div><input name="username" type="text"/></div>
    		<div>真实姓名：</div>
    		<div><input name="name" type="text"/></div>
    		<div>密码：</div>
    		<div><input name="password" type="password"/></div>
    		<div><input type="submit" value="添加"/></div>
    		
    	</form>
  </body>
</html>
