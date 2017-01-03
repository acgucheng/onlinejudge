package cn.acgucheng.onlinejudge.service;

import java.util.ArrayList;
import java.util.List;

import cn.acgucheng.onlinejudge.dao.ExamProblemDAO;
import cn.acgucheng.onlinejudge.entity.Exam;
import cn.acgucheng.onlinejudge.entity.ExamProblem;
import cn.acgucheng.onlinejudge.entity.ExamProblemId;
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
	
	public void insertData(Exam exam,Problem problem,Double value){
		ExamProblemId epi = new ExamProblemId(exam,problem);
		ExamProblem ep = new ExamProblem(epi, value);
		epd.save(ep);
	}
	
	public void deleteByExamProblem(Integer examID,Integer problemID){
		epd.deleteByID(examID,problemID);
	}
	
	public double getValueByExamIDAndProblemID(Integer examID,Integer problemID){
		List<ExamProblem> exam_problems = epd.findByExamIDAndProblemID(examID,problemID);
		return exam_problems.get(0).getValue();
	}
	
	
}
