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
    
    <title>My JSP 'problem_database.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	  .table-padding {
				padding: 10px;
				
			}
  	</style>
	
  </head>
  <%@include file="/menu.jsp" %>
  <style>
  .table-padding {
			padding: 10px;
			
		}
  .medal-padding {
			padding: 30px;
			
		}
  .font-padding{
  	padding-top:10px;
  	padding-bottom:5px;
  }
  .padding-right{
  	padding-right:55px;
  	padding-top:20px;
  }
  
  </style>
  <body>
    <h1 class="text-center page-header"><font>常州大学在线测评题库</font></h1>
   	<div class="table-padding">
	    <table class="table table-striped table-hover">
	    <thead>
	    	<td width="10%;">题目编号</td>
	    	<td width="40%;">题目名</td>
	    	<td width="20%;">题目类型</td>
	    	<td width="20%;">出题人</td>
	    	<td width="10%;">操作</td>
	    </thead>
	    <s:iterator var="p" value="problemList">
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
	    		<td><a class="btn btn-success" href="${pageContext.request.contextPath }/teacher/problem_detail?problemID=<s:property value="#p.id"/>">详情</a></td>
	    	</tr>
	    </s:iterator>
	    </table>
	</div>
		<div class="text-right padding-right">
    	<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" >
			添加试题
		</button>
		</div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" 
								aria-hidden="true">×
						</button>
						<h4 class="modal-title" id="myModalLabel" >
							添加试题
						</h4>
					</div>
					<form action="${pageContext.request.contextPath }/teacher/add_problem" method="post">
					<div class="modal-body medal-padding">
			    		<div class="font-padding"><font>题目名：</font></div>
			    		<div><input id ="title" name="title" type="text" class="form-control"/></div>
			    		<div class="font-padding"><font>题目类型：</font></div>
			    		<div>
				    		<select id="type" name="type" class="selectpicker">
				    			<option value="0">选择题</option>
				    			<option value="1">填空题</option>
				    		</select>
				    	</div>
				    	<div class="font-padding"><font>题目描述：</font></div>
				    	<div>
				    		<textarea id="description" name="description" cols="40"  rows="5" class="form-control"></textarea>
				    	</div>
				    	<div class="font-padding"><font>选项：（每个选项之间用换行分隔）：</font></div>
				    	<div>
				    		<textarea id="selection" name="selection" cols="40" rows="5" class="form-control"></textarea>
				    	</div>
				    	<div class="font-padding"><font>答案（选择题输入对应大写字母即可）：</font></div>
			    		<div><input name="answer" type="text" class="form-control"/></div>	
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" 
								data-dismiss="modal">关闭
						</button>
					 	<input type="submit" value="添加" class="btn btn-primary"/>
					</div>
					</form>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	    	
    	
  </body>
</html>
