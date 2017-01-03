package cn.acgucheng.onlinejudge.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.acgucheng.onlinejudge.entity.Exam;
import cn.acgucheng.onlinejudge.entity.Problem;
import cn.acgucheng.onlinejudge.entity.Student;
import cn.acgucheng.onlinejudge.entity.StudentExam;
import cn.acgucheng.onlinejudge.entity.StudentExamId;
import cn.acgucheng.onlinejudge.service.ExamProblemService;
import cn.acgucheng.onlinejudge.service.ExamService;
import cn.acgucheng.onlinejudge.service.ProblemService;
import cn.acgucheng.onlinejudge.service.StudentExamService;
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
		//从页面获得参数
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		ExamProblemService eps = new ExamProblemService();
		List<Problem> problems = eps.getProblemsByExamID(Integer.parseInt(examID));
		//计算每道题的得分并相加得到总成绩
		Double ans = new Double(0);
		for(int i = 0; i < problems.size(); i++){
			String value = request.getParameter(problems.get(i).getId().toString());
			BaseProblem problem = null;
			if(problems.get(i).getType() == 0)
				problem = new SingleSelectProblem(problems.get(i));
			ans = ans + problem.checkAnswer(examID, value);
		}
		//将总成绩存入数据库的student_exam表中
		Student student = (Student) context.getSession().get("Student");
		ExamService es = new ExamService();
		Exam exam = es.findByID(Integer.parseInt(examID));
		StudentExamId sei = new StudentExamId(student,exam);
		StudentExam se = new StudentExam(sei,ans);
		StudentExamService ses = new StudentExamService();
		ses.insertData(se);
		return "success";
	}
}
