<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css"/>
<script src="${pageContext.request.contextPath }/jquery/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线考试系统</title>
    
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
	  <div class="text-right">
	  	
	  </div>
	  
	  
	  <nav class="navbar navbar-inverse" role="navigation">
	    <div class="container-fluid">
	    	<div class="navbar-header">
            <a class="navbar-brand" href="#">在线考试系统</a>
        	</div>
        	<div>
		    	<ul class="nav navbar-nav">
				    <li><a href="${pageContext.request.contextPath }/teacher/problem_database">查看题库</a></li>
				    <li><a href="${pageContext.request.contextPath }/check_exam">查看考试</a></li>
				    <li><a href="${pageContext.request.contextPath }/teacher/check_score">查看成绩</a></li>
				    <li><a href="${pageContext.request.contextPath }/teacherLogin">老师登录</a></li>
			    </ul>
		    </div>
		    <ul class="nav navbar-nav navbar-right"> 
	            <s:if test="#session.Student == null">
		  			<s:if test="#session.Teacher == null">
				  		<li><a href="login">登录</a></li>
				  		<li><a href="regist" align="right">注册</a></li>
			  		</s:if>
			  		<s:else>
			  			<s:if test ="#session.Admin!=null">
		  					<li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                    <s:property value="#session.Teacher.name"/><b class="caret"></b>
				                </a>
				                <ul class="dropdown-menu">
				                    <li class="text-right"><a href="${pageContext.request.contextPath }/index">个人设置</a></li>
				                    <li class="text-right"><a href="${pageContext.request.contextPath }/admin/student_manage">学生管理</a></li>
				                    <li class="text-right"><a href="${pageContext.request.contextPath }/admin/teacher_manage">老师管理</a></li>
				                	<li class="text-right"><a href="${pageContext.request.contextPath }/logout">退出</a></li>
				                </ul>
				            </li>
		  				</s:if>
		  				<s:else>
				  			<li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                    <s:property value="#session.Teacher.name"/><b class="caret"></b>
				                </a>
				                <ul class="dropdown-menu">
				                    <li class="text-right"><a href="#">个人设置</a></li>
				                    <li class="text-right"><a href="${pageContext.request.contextPath }/logout">退出</a></li>
				                </ul>
				            </li>
			  			</s:else>
			  		</s:else>
			  	</s:if>
			  	<s:else>
			  		<li class="dropdown">
		                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		                    <s:property value="#session.Student.name"/><b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li class="text-right"><a href="#"><s:property value="#session.Student.class_"/></a></li>
		                    <li class="text-right"><a href="#">个人设置</a></li>
		                    <li class="text-right"><a href="${pageContext.request.contextPath }/logout">退出</a></li>
		                </ul>
		            </li>
			  	</s:else> 
			  	
        	</ul> 
	    </div>
	    </nav>
  </body>
</html>
