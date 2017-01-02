package cn.acgucheng.onlinejudge.service;

import java.util.ArrayList;
import java.util.List;

import cn.acgucheng.onlinejudge.dao.ExamProblemDAO;
import cn.acgucheng.onlinejudge.entity.ExamProblem;
import cn.acgucheng.onlinejudge.entity.Problem;

public class ExamProblemService {
	ExamProblemDAO epd = new ExamProblemDAO();
	
	public List getProblemsByExamID(Integer id){
		List<ExamProblem> exam_problems = epd.findByExamID(id);
		List<Problem> problems = new ArrayList<Problem>();
		for(int i = 0; i < exam_problems.size(); i++){
			problems.add(exam_problems.get(i).getId().getProblem());
		}
		return problems;
	}
}
