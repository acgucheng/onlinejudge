<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<Script type="text/javascript" language="JavaScript">
		function checkForm(){
			//校验用户名
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var repassword = document.getElementById("repassword").value;
			var name = document.getElementById("name").value;
			var Class = document.getElementById("class").value;
			var hint = document.getElementById("hint"); hint.textContent="";
			var hint_username = document.getElementById("hint_username"); hint_username.textContent="";
			var hint_password = document.getElementById("hint_password"); hint_password.textContent="";
			var hint_repassword = document.getElementById("hint_repassword"); hint_repassword.textContent="";
			if(username==''){
				//alert("用户名不能为空");
				hint_username.textContent = "用户名不能为空";
				return false;
			}
			if(password.length<6){
				hint_password.textContent = "密码过短";
				return false;
			}
			if(repassword!=password){
				hint_repassword.textContent = "两次输入密码不一致";
				return false;
			}
			if(Class=='' || name==''){
				hint.textContent = "请完整填写注册信息！";
				return false;
			}
			return true;
		}
		function checkUserName(){
			
		}
	</Script>
  </head>
  
  
  <body>
  	<div><h2>用户注册</h2></div>
    <div>
    	<form action="student_regist" method="post" onsubmit="return checkForm();">
	    	<table>
		    	<tr>
		    		<td><font>用户名：</font></td> 
		    		<td><input id="username" name="username" type="text" onblur="checkUserName"></td>
		    		<td><font id="hint_username" color="red"></font>
		    	</tr>
		    	<tr>
		    		<td><font>密码：</font></td>
		    		<td> <input id="password" name="password" type="password"></td>
		    		<td><font id="hint_password" color="red"></font>
		    	</tr>
		    	<tr>
		    		<td><font>确认密码：</font></td>
		    		<td> <input id="repassword" name="repassword" type="password"></td>
		    		<td><font id="hint_repassword" color="red"></font>
		    	</tr>
		    	<tr>
		    		<td><font>真实姓名:</font></td>
		    		<td><input id="name" name="name" type="text"></td>
		    	</tr>
		    	<tr>
		    		<td><font>班级:</font></td>
		    		<td><input id="class" name="class" type="text"></td>
		    	</tr>
		    	<tr>
		    		<td colspan="2"><font id="hint" size="1px" color="red"></font></td>
		    	</tr>
		    	<tr>
		    		<td colspan="2" align="center"><input id="fuck" type="submit" value="注册" ></td>
		    	</tr>
		    	
	    	</table>
    		
    	</form>
    
    </div>
  </body>
</html>
