package cn.acgucheng.onlinejudge.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import cn.acgucheng.onlinejudge.dao.StudentDAO;
import cn.acgucheng.onlinejudge.entity.Student;
import cn.acgucheng.onlinejudge.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport{
	public String username;
	public String regist(){
		return "success";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String CheckUserName() throws IOException{
		
		StudentService studentservice = new StudentService();
		
		Student student = studentservice.findByUsername(username);
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		if(student!=null){
			//该用户名已存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}
		else{
			//用户名可以使用
			
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
}
