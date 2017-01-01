<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_problem.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function checkproblem(){
			
		}
	</script>
  </head>
  
  <body>
    <font>新建题目</font>
    <div>
    	<form action="add_problem" method="post" >
	    	<div><font>题目名：</font></div>
	    	<div><input id="title" name="title"/></div>
	    	<div><font>题目类型：</font></div>
	    	<div>
	    		<select id="type" name="type">
	    			<option value="0">选择题</option>
	    			<option value="1">填空题</option>
	    		</select>
	    	</div>
	    	<div><font>题目描述：</font></div>
	    	<div>
	    		<textarea id="description" name="description" cols="40"  rows="5"></textarea>
	    	</div>
	    	<div><font>选项（每个选项之间用换行分隔）：</font></div>
	    	<div>
	    		<textarea id="selection" name="selection" cols="40" rows="5"></textarea>
	    	</div>
	    	<div><font>答案（选择题输入对应大写字母即可）：</font></div>
	    	<div>
	    		<input id="answer" name="answer" type="text"/>
	    	</div>
	    		<input type="submit" value="添加题目"/>
    	</form>
    </div>
  </body>
</html>
