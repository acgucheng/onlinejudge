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
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <font size="8px" color="">学生登录</font>
    <div>
	    <form action="student_login" method="post">
	    	
	    	<div>用户名：</div>
	    	<div><input id="username" name="username" type="text"/></div>
	    	<div>密码：</div>
	    	<div><input id="password" name="password" type="password"/></div>
	    	<div>
	    		<font size="1px" color="red"><s:property value="hint" /></font>
	    	</div>
	    	<input type="submit" value="登录"/>
	    	
	    </form>
    </div>
  </body>
</html>
