package cn.acgucheng.onlinejudge.service;

import java.util.List;

import cn.acgucheng.onlinejudge.dao.ExamDAO;
import cn.acgucheng.onlinejudge.entity.Exam;

public class ExamService {
	ExamDAO examDao = new ExamDAO();
	
	public void insertData(Exam exam){
		examDao.save(exam);
	}
	
	public List findAll(){
		return examDao.findAll();
	}
	
}
