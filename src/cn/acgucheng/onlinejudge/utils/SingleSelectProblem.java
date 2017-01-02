package cn.acgucheng.onlinejudge.utils;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.acgucheng.onlinejudge.entity.Problem;

public class SingleSelectProblem extends BaseProblem{
	
	public SingleSelectProblem(Problem problem) {
		super(problem);
		// TODO Auto-generated constructor stub
	}

	ArrayList<String> selections;

	
	
	public ArrayList<String> getSelections() {
		return selections;
	}



	public void setSelections(ArrayList<String> selections) {
		this.selections = selections;
	}



	@Override
	public void display() {
		// TODO Auto-generated method stub
		super.display();
		if(selections==null) selections = new ArrayList<>();
		String[] tmp = getSelection().split("\r\n");
		for (String str : tmp) {
			if(str != "" && str != null)
			selections.add(str);
		}
		ActionContext.getContext().getValueStack().set("problem",this);
		
	}
}
