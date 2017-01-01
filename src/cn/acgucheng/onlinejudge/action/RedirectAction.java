package cn.acgucheng.onlinejudge.action;

import cn.acgucheng.onlinejudge.dao.StudentDAO;
import cn.acgucheng.onlinejudge.entity.Student;

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
}
