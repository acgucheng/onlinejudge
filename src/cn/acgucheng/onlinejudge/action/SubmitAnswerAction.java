package cn.acgucheng.onlinejudge.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.acgucheng.onlinejudge.entity.Problem;
import cn.acgucheng.onlinejudge.service.ExamProblemService;
import cn.acgucheng.onlinejudge.service.ProblemService;
import cn.acgucheng.onlinejudge.utils.BaseProblem;
import cn.acgucheng.onlinejudge.utils.SingleSelectProblem;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitAnswerAction extends ActionSupport{
	
	private String examID;
	
	public String getExamID() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}

	public String submitAnswer(){
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		ExamProblemService eps = new ExamProblemService();
		List<Problem> problems = eps.getProblemsByExamID(Integer.parseInt(examID));
		Double ans = new Double(0);
		for(int i = 0; i < problems.size(); i++){
			String value = request.getParameter(problems.get(i).getId().toString());
			BaseProblem problem = null;
			if(problems.get(i).getType() == 0)
				problem = new SingleSelectProblem(problems.get(i));
			ans = ans + problem.checkAnswer(examID, value);
		}
		
		return "success";
	}
}
