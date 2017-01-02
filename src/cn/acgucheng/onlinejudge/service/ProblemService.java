package cn.acgucheng.onlinejudge.service;

import java.util.ArrayList;
import java.util.List;

import cn.acgucheng.onlinejudge.dao.ProblemDAO;
import cn.acgucheng.onlinejudge.entity.Problem;
import cn.acgucheng.onlinejudge.utils.BaseProblem;

public class ProblemService {
	private ProblemDAO problemDao = new ProblemDAO();
	public void insertData(Problem problem){
		problemDao.save(problem);
	}
	
	public List findAll(){
		List problemList =  problemDao.findAll();
		List problems = new ArrayList<BaseProblem>();
		for(int i = 0; i < problemList.size(); i++)
			problems.add(problemList.get(i));
		return problems;
	}
	
	public Problem findByID(Integer id){
		return problemDao.findById(id);
	}
	
}
