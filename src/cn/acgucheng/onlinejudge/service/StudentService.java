package cn.acgucheng.onlinejudge.service;

import java.util.List;

import cn.acgucheng.onlinejudge.dao.StudentDAO;
import cn.acgucheng.onlinejudge.entity.Student;

public class StudentService {
	public Student findByUsername(String name){
		StudentDAO studentdao = new StudentDAO();
		
		List studentList = studentdao.findByUsername(name);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!");
		if(studentList.size()>0){
			return (Student) studentList.get(0);
		}
		return null;
	}
}
