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
	 * ע������ж��û����Ƿ���ڵ�Ajax�ű�����Ӧ�¼�
	 * @return һ���޷��أ�ֻ�޸Ľ���
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
			//���û����Ѵ���
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
		}
		else{
			//�û�������ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}
	
	/**
	 * ѧ��ע���¼�����Ӧaction
	 * @return ��ת���
	 */
	public String registStudent(){
		StudentService studentService = new StudentService();
		Student student = new Student(username,name,classno,password);
		//�ж����ݿ����Ƿ�����û���
		if(studentService.findByUsername(username)==null){  
			//���ݿⲻ���ڸ��û��������Դ���
			studentService.insertData(student);
			return "regist_success";
		}
		else{
			//���ݿ�����û��������Դ���
			return "regist_fail";
		}
	}
	
}
