package cn.acgucheng.onlinejudge.action;

import cn.acgucheng.onlinejudge.dao.StudentDAO;
import cn.acgucheng.onlinejudge.entity.Student;

import com.opensymphony.xwork2.ActionSupport;

public class RedirectAction extends ActionSupport{
	public String indexRedirect(){
		return "indexPage";
	}
	
	public String registRedirect(){
		System.out.println("redirect to registPage!!!");
		return "registPage";
	}
	
}
