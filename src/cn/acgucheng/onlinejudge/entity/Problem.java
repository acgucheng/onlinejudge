package cn.acgucheng.onlinejudge.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem entity. @author MyEclipse Persistence Tools
 */

public class Problem implements java.io.Serializable {

	// Fields

	protected Integer id;
	protected Teacher teacher;
	protected Integer type;
	protected String description;
	protected String selection;
	protected String answer;
	protected String title;
	protected Set examProblems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Problem() {
	}

	/** minimal constructor */
	public Problem(Teacher teacher, Integer type, String description,
			String selection, String answer,String title) {
		this.teacher = teacher;
		this.type = type;
		this.description = description;
		this.selection = selection;
		this.answer = answer;
		this.title = title;
	}

	/** full constructor */
	public Problem(Teacher teacher, Integer type, String description,
			String selection, String answer, Set examProblems) {
		this.teacher = teacher;
		this.type = type;
		this.description = description;
		this.selection = selection;
		this.answer = answer;
		this.examProblems = examProblems;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSelection() {
		return this.selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Set getExamProblems() {
		return this.examProblems;
	}

	public void setExamProblems(Set examProblems) {
		this.examProblems = examProblems;
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