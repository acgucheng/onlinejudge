package cn.acgucheng.onlinejudge.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.acgucheng.onlinejudge.entity.Exam;
import cn.acgucheng.onlinejudge.entity.Teacher;
import cn.acgucheng.onlinejudge.service.ExamService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateExamAction extends ActionSupport{
	private String name;
	private String timeLimit;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String createExam(){
		Teacher teacher = (Teacher) ServletActionContext.getRequest().getSession().getAttribute("Teacher");
		Exam exam;
		try {
			exam = new Exam(teacher, name, Integer.parseInt(timeLimit));
		} catch (Exception e) {
			ActionContext.getContext().getValueStack().set("hint", "您输入的信息有误！");
			return "fail";
			// TODO: handle exception
		}
		exam.setStatus(true);
		ExamService es = new ExamService();
		es.insertData(exam);
		return "success";
	}
}
