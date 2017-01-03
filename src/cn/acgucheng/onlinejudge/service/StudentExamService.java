package cn.acgucheng.onlinejudge.service;

import java.util.List;

import cn.acgucheng.onlinejudge.dao.StudentExamDAO;
import cn.acgucheng.onlinejudge.entity.StudentExam;

public class StudentExamService {
	StudentExamDAO sed = new StudentExamDAO();
	
	public void insertData(StudentExam se){
		sed.save(se);
	}
	
	public List findByExamID(String examID){
		return sed.findByExamID(examID);
	}
	
}
