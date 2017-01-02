package cn.acgucheng.onlinejudge.utils;

import java.util.ArrayList;
import java.util.List;

import cn.acgucheng.onlinejudge.entity.Problem;

import com.opensymphony.xwork2.ActionContext;

public class ProblemManager {
	List<BaseProblem> problems = new ArrayList<BaseProblem>();
	
	public ProblemManager(List<Problem> problems) {
		super();
		for(int i = 0; i < problems.size(); i++){
			if(problems.get(i).getType()==0){
				this.problems.add(new SingleSelectProblem(problems.get(i)));
			}
		}
	}

	public void DisplayProblems(){
		for(int i = 0; i < problems.size(); i++){
			BaseProblem problem = problems.get(i);
			problem.display();
		}
		ActionContext.getContext().getValueStack().set("problemList", problems);
	}
}
