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
	public String password;
	public String name;
	public String classno;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 注册界面判断用户名是否存在的Ajax脚本的响应事件
	 * @return 一般无返回，只修改界面
	 * @throws IOException
	 */
	public String CheckUserName() throws IOException{
		StudentService studentservice = new StudentService();
		if(username.equals("")){
			return NONE;
		}
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
	
	/**
	 * 学生注册事件的响应action
	 * @return 跳转结果
	 */
	public String registStudent(){
		StudentService studentService = new StudentService();
		Student student = new Student(username,name,classno,password);
		//判断数据库中是否存在用户名
		if(studentService.findByUsername(username)==null){  
			//数据库不存在该用户名，可以创建
			studentService.insertData(student);
			return "regist_success";
		}
		else{
			//数据库存在用户，不可以创建
			return "regist_fail";
		}
	}
	
}
