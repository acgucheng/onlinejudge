<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/menu.jsp" %>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'check_exam.jsp' starting page</title>
    
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
    <div>
    	<h1 class="page-header text-center">当前正在进行的考试有</h1>
    </div>
    <div class="table-padding">
    	<table class="table table-striped table-hover ">
    		<thead>
    			<td width="20%">考试编号</td>
    			<td width="40%">考试名称</td>
    			<td width="20%">监考老师</td>
    			<td width="10%">操作</td>
    		</thead>
    		<s:iterator var="p" value="Exams">
    			<tr>
    				<td><s:property value="#p.id"/></td>
    				<td><s:property value="#p.name"/></td>
    				<td><s:property value="#p.teacher.name"/></td>
 					<s:if test="#session.Teacher!=null">
    					<td><a class="btn btn-success" href="${pageContext.request.contextPath }/teacher/edit_exam?examID=<s:property value="#p.id"/>">详情</a></td>
    				</s:if>
    				<s:else>
    					<td><a class="btn btn-success" href="${pageContext.request.contextPath }/student/join_exam?examID=<s:property value="#p.id"/>">参加</a></td>
    				</s:else>
    			</tr>
    		</s:iterator>
    	</table>
    </div>
    <s:if test="#session.Teacher!=null">
    		<div class="text-right padding-right">
		    	<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" >
					创建考试
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
								创建考试
							</h4>
						</div>
						<form action="${pageContext.request.contextPath }/teacher/create_exam_action" method="post">
						<div class="modal-body medal-padding">
				    		<div class="font-padding"><font>考试名称：</font></div>
				    		<div><input name="name" type="text" class="form-control"/></div>
				    		<div class="font-padding"><font>考试时间：</font></div>
				    		<div><input name="timeLimit" type="text" class="form-control"/></div>	
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
    </form>
    </s:if>
  </body>
</html>
