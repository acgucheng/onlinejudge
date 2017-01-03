package cn.acgucheng.onlinejudge.action;

import java.util.ArrayList;
import java.util.List;

import cn.acgucheng.onlinejudge.dao.StudentDAO;
import cn.acgucheng.onlinejudge.entity.Exam;
import cn.acgucheng.onlinejudge.entity.Problem;
import cn.acgucheng.onlinejudge.entity.Student;
import cn.acgucheng.onlinejudge.service.ExamProblemService;
import cn.acgucheng.onlinejudge.service.ExamService;
import cn.acgucheng.onlinejudge.service.ProblemService;
import cn.acgucheng.onlinejudge.utils.BaseProblem;
import cn.acgucheng.onlinejudge.utils.ProblemManager;
import cn.acgucheng.onlinejudge.utils.SingleSelectProblem;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RedirectAction extends ActionSupport{
	/**
	 * 请求网站首页的action
	 * @return
	 */
	public String indexRedirect(){
		return "indexPage";
	}
	
	/**
	 * 请求学生注册界面的action
	 * @return
	 */
	public String registRedirect(){
		return "registPage";
	}
	
	/**
	 * 请求学生登录界面的action
	 * @return
	 */
	public String loginRedirect(){
		return "loginPage";
	}
	
	public String teacherLoginRedirect(){
		return "teacherLoginPage";
	}
	
	public String problemDatabaseRedirect(){
		ProblemService problemService = new ProblemService();
		List problems = problemService.findAll();
		ProblemManager pm = new ProblemManager(problems);
		pm.DisplayProblems();
		return "problemDatabasePage";
	}
	
	public String createExamRedirect(){
		return "createExamPage";
	}
	
	private String examID;
	
	public String getExamID() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}
	
	public String editExamRedirect(){
		//Exam exam = (Exam) ActionContext.getContext().getValueStack().findValue("Exam");
		ExamProblemService eps = new ExamProblemService();
		List problemList = eps.getProblemsByExamID(Integer.parseInt(examID));
		ActionContext.getContext().getValueStack().set("examID",examID);
		List<BaseProblem> problems = new ArrayList<BaseProblem>();
		for(int i = 0; i < problemList.size(); i++){
			Problem problem =  (Problem) problemList.get(i);
			if(problem.getType() == 0)
				problems.add(new SingleSelectProblem(problem));
		}
		for(int i = 0; i < problems.size(); i++){
			problems.get(i).display();
		}
		ActionContext.getContext().getValueStack().set("ExamProblems", problems);
		return "editExamPage";
	}
	

	public String checkExamRedirect(){
		ExamService es = new ExamService();
		List exams = es.findAll();
		ActionContext.getContext().getValueStack().set("Exams",exams);
		return "checkExamPage";
	}
	
	public String joinExamRedirect(){
		ExamProblemService eps = new ExamProblemService();
		List problemList = eps.getProblemsByExamID(Integer.parseInt(examID));
		ActionContext.getContext().getValueStack().set("examID",examID);
		List<BaseProblem> problems = new ArrayList<BaseProblem>();
		for(int i = 0; i < problemList.size(); i++){
			Problem problem =  (Problem) problemList.get(i);
			if(problem.getType() == 0)
				problems.add(new SingleSelectProblem(problem));
		}
		for(int i = 0; i < problems.size(); i++){
			problems.get(i).display();
		}
		ActionContext.getContext().getValueStack().set("ExamProblems", problems);
		return "joinExamPage";
	}
	
}
