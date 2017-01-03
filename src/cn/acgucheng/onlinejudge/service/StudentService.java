package cn.acgucheng.onlinejudge.service;

import java.util.List;

import cn.acgucheng.onlinejudge.dao.StudentDAO;
import cn.acgucheng.onlinejudge.entity.Student;

public class StudentService {
	public Student findByUsername(String name){
		StudentDAO studentdao = new StudentDAO();
		
		List studentList = studentdao.findByUsername(name);
		if(studentList.size()>0){
			return (Student) studentList.get(0);
		}
		return null;
	}
	
	public void insertData(Student student){
		StudentDAO studentDao = new StudentDAO();
		studentDao.save(student);
	}
	
	public Student checkIdentity(String username,String password){
		StudentDAO studentdao = new StudentDAO();
		List studentList = studentdao.findByUsernameAndPassword(username, password);
		if(studentList.size()>0){
			return (Student) studentList.get(0);
		}
		else{
			return null;
		}
	}
	
	public Student findByID(Integer id){
		StudentDAO sd = new StudentDAO();
		return sd.findById(id);
	}
	
}
