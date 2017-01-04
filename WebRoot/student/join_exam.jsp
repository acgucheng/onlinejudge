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
    
    <title>My JSP 'join_exam.jsp' starting page</title>
    
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
  	.padding-panel{
  		padding:20px;
  		margin:20px;
  	}
  	.padding-selection{
  		padding:10px;
  		margin:10px;
  	}
  </style>
  <body>
    <div><h1 class="text-center page-header">欢迎使用常州大学在线考试系统</h1></div>
    <form action="${pageContext.request.contextPath }/student/submit_answer" method="post">
    	<input type="hidden" name="examID" value="<s:property value="examID"/>"/>
		<s:iterator var="p" value="ExamProblems">
    	<div class="panel panel-default padding-panel">
	    	<div><font size="4px"><s:property value="#p.description"/></font></div>
	    	<s:if test="#p.type==0">
	    		<div>
	    			<%int a=0; %>
	    			<div class="padding-selection">
	    			<s:iterator var="i" value="#p.selections">
	    				<input type="radio" value="<%=a%>" name="<s:property value="#p.id"/>"><font size="4px"><s:property value="#i"/></font><br>
	    				<%a++; %>
	    			</s:iterator>
	    			</div>
	    		</div>
	    	</s:if>
	    	<s:else>
	    		fuck!!
	    	</s:else>
    	</div>
		</s:iterator>
	    <div class="text-center"><input class="btn btn-success btn-lg" type="submit" value="&nbsp&nbsp&nbsp&nbsp提交&nbsp&nbsp&nbsp&nbsp  "/></div>
	</form>
  </body>
</html>
