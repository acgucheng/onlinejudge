package cn.acgucheng.onlinejudge.action;

import javax.servlet.http.HttpServletResponse;

import cn.acgucheng.onlinejudge.entity.Problem;
import cn.acgucheng.onlinejudge.service.ProblemService;
import cn.acgucheng.onlinejudge.utils.BaseProblem;
import cn.acgucheng.onlinejudge.utils.SingleSelectProblem;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProblemDetailAction extends ActionSupport{
	private String problemID;
	private BaseProblem bp;
	
	public BaseProblem getBp() {
		return bp;
	}

	public void setBp(BaseProblem bp) {
		this.bp = bp;
	}

	public String getProblemID() {
		return problemID;
	}

	public void setProblemID(String problemID) {
		this.problemID = problemID;
	}

	public String checkProblemDetail(){
		ProblemService ps = new ProblemService();
		Problem problem = ps.findByID(Integer.parseInt(problemID));
		if(problem.getType().equals(0)) 
			bp = new SingleSelectProblem(problem);
		bp.display();
		return "checkProblemDetail";
	}
}
