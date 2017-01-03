package cn.acgucheng.onlinejudge.action;

import java.util.ArrayList;
import java.util.List;

import cn.acgucheng.onlinejudge.entity.StudentExam;
import cn.acgucheng.onlinejudge.service.StudentExamService;
import cn.acgucheng.onlinejudge.utils.StudentScore;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckScoreAction extends ActionSupport{
	private String examID;
	
	public String getExamID() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}

	public String examScore(){
		StudentExamService ses = new StudentExamService();
		List scores = ses.findByExamID(examID);
		List studentScoreList = new ArrayList<StudentScore>();
		for(int i = 0; i < scores.size(); i++){
			studentScoreList.add(new StudentScore((StudentExam) scores.get(i)));
		}
		ActionContext.getContext().getValueStack().set("studentScoreList", studentScoreList);
		return "success";
	}
}
