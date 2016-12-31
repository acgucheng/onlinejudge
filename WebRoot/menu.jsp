<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menu.jsp' starting page</title>
    
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
	  <div>
	  	<s:if test="#session.Student == null">
		  		<a href="login">登录</a>
		  		<a href="regist" align="right">注册</a>
	  	</s:if>
	  	<s:else>
	  		<s:property value="#session.Student.name"/>
	  		<a href="${pageContext.request.contextPath }/index">个人设置</a>
	  		<a href="${pageContext.request.contextPath }/logout">退出</a>
	  	</s:else>
	  </div>
  </body>
</html>
