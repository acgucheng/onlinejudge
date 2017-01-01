package cn.acgucheng.onlinejudge.action;

import cn.acgucheng.onlinejudge.dao.StudentDAO;
import cn.acgucheng.onlinejudge.entity.Student;

import com.opensymphony.xwork2.ActionSupport;

public class RedirectAction extends ActionSupport{
	/**
	 * ������վ��ҳ��action
	 * @return
	 */
	public String indexRedirect(){
		return "indexPage";
	}
	
	/**
	 * ����ѧ��ע������action
	 * @return
	 */
	public String registRedirect(){
		return "registPage";
	}
	
	/**
	 * ����ѧ����¼�����action
	 * @return
	 */
	public String loginRedirect(){
		return "loginPage";
	}
	
	public String teacherLoginRedirect(){
		return "teacherLoginPage";
	}
}
