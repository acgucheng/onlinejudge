package cn.acgucheng.onlinejudge.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Exam entity. @author MyEclipse Persistence Tools
 */

public class Exam implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private String name;
	private Boolean status;
	private Integer timeLimit;
	private Set examProblems = new HashSet(0);
	private Set studentExams = new HashSet(0);

	// Constructors

	public Exam(){
		super();
	}
	
	public Exam(Exam exam){
		this.id = exam.getId();
		this.teacher = exam.getTeacher();
		this.name = exam.getName();
		this.status = exam.getStatus();
		this.timeLimit = exam.getTimeLimit();
		this.examProblems = exam.getExamProblems();
		this.studentExams = exam.getStudentExams();
	}
	
	/** default constructor 
	 * @param timeLimit2 
	 * @param b 
	 * @param name2 
	 * @param teacher2 */

	/** minimal constructor */
	public Exam(Teacher teacher, String name, Integer timeLimit) {
		this.teacher = teacher;
		this.name = name;
		this.timeLimit = timeLimit;
	}

	/** full constructor */
	public Exam(Teacher teacher, String name, Boolean status,
			Integer timeLimit, Set examProblems, Set studentExams) {
		this.teacher = teacher;
		this.name = name;
		this.status = status;
		this.timeLimit = timeLimit;
		this.examProblems = examProblems;
		this.studentExams = studentExams;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	public Set getExamProblems() {
		return this.examProblems;
	}

	public void setExamProblems(Set examProblems) {
		this.examProblems = examProblems;
	}

	public Set getStudentExams() {
		return this.studentExams;
	}

	public void setStudentExams(Set studentExams) {
		this.studentExams = studentExams;
	}

}