package cn.acgucheng.onlinejudge.service;

import cn.acgucheng.onlinejudge.dao.ProblemDAO;
import cn.acgucheng.onlinejudge.entity.Problem;

public class ProblemService {
	private ProblemDAO problemDao = new ProblemDAO();
	public void insertData(Problem problem){
		problemDao.save(problem);
	}
}
