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
    
    <title>My JSP 'add_exam.jsp' starting page</title>
    
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
    <h1 class="text-center page-header">编辑考试</h1>
    <div>当前已有试题:</div>
    <div class="table-padding">
	    <table class="table table-striped table-hover">
	    	<thead>
	    		<td width="15%;">编号</td>
	    		<td width="40%;">试题名称</td>
	    		<td width="15%;">类型</td>
	    		<td width="20%;">命题人</td>
	    		<td width="5%;">操作</td>
	    		<td width="5%;">操作</td>
	    	</thead>
		    <s:iterator var="p" value="ExamProblems">
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
				   		<td><a href="${pageContext.request.contextPath }/teacher/problem_detail?problemID=<s:property value="#p.id"/> " class="btn btn-success">详情</a></td>
		    			<td><a href="${pageContext.request.contextPath }/teacher/delete_problem_from_exam?problemID=<s:property value="#p.id"/>&examID=<s:property value="examID"/>" class="btn btn-danger">删除</a>
		    	<tr>
		    </s:iterator>
	    </table>
	    <div>
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
						<form action="${pageContext.request.contextPath }/teacher/add_problem_to_exam" method="post">
						<div class="modal-body medal-padding">
							<input name="examID" type="hidden" value="<s:property value="examID"/>">
				    		<div class="font-padding"><font>题目编号：</font></div>
				    		<div><input name="problemID" type="text" class="form-control"/></div>
				    		<div class="font-padding"><font>分值：</font></div>
				    		<div><input name="value" type="text" class="form-control"/></div>	
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
	    	
	    		
	    	<div></div>
	    </div>
    </div>
  </body>
</html>
