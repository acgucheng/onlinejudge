package cn.acgucheng.onlinejudge.action;

import cn.acgucheng.onlinejudge.entity.Exam;
import cn.acgucheng.onlinejudge.entity.ExamProblemId;
import cn.acgucheng.onlinejudge.entity.Problem;
import cn.acgucheng.onlinejudge.service.ExamProblemService;
import cn.acgucheng.onlinejudge.service.ExamService;
import cn.acgucheng.onlinejudge.service.ProblemService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditExamAction extends ActionSupport{
	
	private String problemID;
	private String examID;
	private String value;
	
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getExamID() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}

	public String getProblemID() {
		return problemID;
	}

	public void setProblemID(String problemID) {
		this.problemID = problemID;
	}

	public String addProblemToExam(){
		ProblemService ps = new ProblemService();
		ExamService es = new ExamService();
		Exam exam = es.findByID(Integer.parseInt(examID));
		Problem problem = ps.findByID(Integer.parseInt(problemID));
		if(problem == null){
			ActionContext.getContext().getValueStack().set("hint", "题库中未找到相应题目");
		}
		ExamProblemService eps = new ExamProblemService();
		try {
			eps.insertData(exam, problem, Double.parseDouble(value));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			ActionContext.getContext().getValueStack().set("hint", "输入数据不合法");
			e.printStackTrace();
		}
		return "success";
	}
	
	public String deleteProblemFromExam(){
		//ProblemService ps = new ProblemService();
		//ExamService es = new ExamService();
		//Exam exam = es.findByID(Integer.parseInt(examID));
		//Problem problem = ps.findByID(Integer.parseInt(problemID));
		ExamProblemService eps = new ExamProblemService();
		eps.deleteByExamProblem(Integer.parseInt(examID),Integer.parseInt(problemID));
		return "success";
	}
	

}
