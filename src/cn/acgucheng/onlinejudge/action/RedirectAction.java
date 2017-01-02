package cn.acgucheng.onlinejudge.action;

import java.util.List;

import cn.acgucheng.onlinejudge.dao.StudentDAO;
import cn.acgucheng.onlinejudge.entity.Student;
import cn.acgucheng.onlinejudge.service.ProblemService;
import cn.acgucheng.onlinejudge.utils.BaseProblem;
import cn.acgucheng.onlinejudge.utils.ProblemManager;

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
}
