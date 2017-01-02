package cn.acgucheng.onlinejudge.utils;

import cn.acgucheng.onlinejudge.entity.Problem;
import cn.acgucheng.onlinejudge.entity.Teacher;
import cn.acgucheng.onlinejudge.service.TeacherService;

public class BaseProblem {
	protected Integer id;
	protected Teacher teacher;
	protected Integer type;
	protected String description;
	protected String selection;
	protected String answer;
	protected String title;
	
	public BaseProblem(Problem problem) {
		setId(problem.getId());
		setTitle(problem.getTitle());
		setType(problem.getType());
		setSelection(problem.getSelection());
		setAnswer(problem.getAnswer());
		TeacherService ts = new TeacherService();
		setTeacher(ts.findByID(problem.getTeacher().getId()));
		setDescription(problem.getDescription());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSelection() {
		return selection;
	}
	public void setSelection(String selection) {
		this.selection = selection;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void display(){
		
	}
}
