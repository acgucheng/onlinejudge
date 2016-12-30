package cn.acgucheng.onlinejudge.action;

import cn.acgucheng.onlinejudge.dao.StudentDAO;
import cn.acgucheng.onlinejudge.entity.Student;

import com.opensymphony.xwork2.ActionSupport;

public class FuckAction extends ActionSupport{
	public String execute(){
		StudentDAO studentdao = new StudentDAO();
		Student  student = new Student("acgucheng","¹ÅÔÂÇï" , "ÖÐ¼Ó132", "123456");
		studentdao.save(student);
		return "fuck2";
	}
}
