<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teacher_login.jsp' starting page</title>
    
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
  html {
            background: url(img/student_login2.jpg) no-repeat center center fixed; 
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
  body {
            padding-top: 60px;
            background: transparent;
        }
  .margin-base-vertical {
            margin: 40px 0;
        }
  .margin-font-vertical {
            margin: 5px 0;
        }
  .panel {
			background-color: rgba(255, 255, 255, 0.9);
		}
</style>
  
  <body>
  <div class="container">
  		<div class="row">
  			<div class="col-md-6 col-md-offset-3 row-md-offset-3 panel panel-default">
			    <h1 class="margin-base-vertical text-center">老师登录</h1>
			    <form action="teacher_login" method="post" class="margin-base-vertical">
			    	
			    	<div class="margin-font-vertical">用户名：</div>
			    	<div class="input-group">
			    		<span class="input-group-addon glyphicon glyphicon-user"></span>
			    		<div><input id="username" name="username" type="text" class="form-control input-lg"/></div>
			    	</div>
			    	<div class="margin-font-vertical">密码：</div>
			    	<div class="input-group">
			    		<span class="input-group-addon glyphicon glyphicon-pencil"></span>
			    		<div><input id="password" name="password" type="password" class="form-control input-lg"/></div>
			    	</div>
			    	<div>
			    		<font size="2px" color="red"><s:property value="hint" />&nbsp</font>
			    	</div>
			    	<input type="submit" value="登录" class="btn btn-success btn-lg btn-block"/>
			    	
			    </form>
		    </div>
	    </div>
   </div>
  </body>
</html>
