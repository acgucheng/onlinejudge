package cn.acgucheng.onlinejudge.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.acgucheng.onlinejudge.entity.Problem;
import cn.acgucheng.onlinejudge.entity.Teacher;
import cn.acgucheng.onlinejudge.service.ProblemService;

import com.opensymphony.xwork2.ActionSupport;

public class AddProblemAction extends ActionSupport{
	private String title;
	private int type;
	private String description;
	private String selection;
	private String answer;
	
	public String addProblem(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Teacher teacher = (Teacher) session.getAttribute("Teacher");
		System.out.println(teacher.getId());
		Problem problem = new Problem(teacher, type, description, selection, answer, title);
		ProblemService ps = new ProblemService();
		ps.insertData(problem);
		return NONE;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSelection() {
		return selection;
	}
	public void setSelection(String selection) {
		this.selection = selection;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
