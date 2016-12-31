package cn.acgucheng.onlinejudge.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.acgucheng.onlinejudge.entity.Student;
import cn.acgucheng.onlinejudge.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private String hint = new String("");
	
	
	
	public String getHint() {
		return hint;
	}


	public void setHint(String hint) {
		this.hint = hint;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * ����loginҳ�����ת
	 * @return
	 * @throws IOException 
	 */
	public String studentLogin() throws IOException{
		StudentService studentService = new StudentService();
		Student student = studentService.checkIdentity(username, password);
		if(student!=null){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("Student", student);
			return "login_success";
		}
		else{
			hint="��������û�������������";
			this.addActionError("�û��������벻��ȷ�����֤������!");
			return LOGIN;
		}
	}
	
	public String studentLogout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("Student");
		return "index_page";
	}
}
