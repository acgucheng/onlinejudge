package cn.acgucheng.onlinejudge.service;

import java.util.List;

import cn.acgucheng.onlinejudge.dao.TeacherDAO;
import cn.acgucheng.onlinejudge.entity.Teacher;

public class TeacherService {

	public Teacher checkIdentity(String username,String password){
		TeacherDAO teacherDao = new TeacherDAO();
		List teacherList = teacherDao.findByUsernameAndPassword(username, password);
		if(teacherList.size()>0)
			return (Teacher) teacherList.get(0);
		else
			return null;
	}
	
	public Teacher findByID(Integer id){
		TeacherDAO teacherDao = new TeacherDAO();
		return teacherDao.findById(id);
	}
	
	public List findAll(){
		TeacherDAO td = new TeacherDAO();
		return td.findAll();
	}
	
	public void insertData(Teacher teacher){
		TeacherDAO teacherDao = new TeacherDAO();
		teacherDao.save(teacher);
	}
}
