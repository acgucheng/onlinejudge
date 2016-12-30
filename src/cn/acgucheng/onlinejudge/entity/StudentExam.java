package cn.acgucheng.onlinejudge.entity;


/**
 * StudentExam entity. @author MyEclipse Persistence Tools
 */

public class StudentExam implements java.io.Serializable {

	// Fields

	private StudentExamId id;
	private Double score;

	// Constructors

	/** default constructor */
	public StudentExam() {
	}

	/** minimal constructor */
	public StudentExam(StudentExamId id) {
		this.id = id;
	}

	/** full constructor */
	public StudentExam(StudentExamId id, Double score) {
		this.id = id;
		this.score = score;
	}

	// Property accessors

	public StudentExamId getId() {
		return this.id;
	}

	public void setId(StudentExamId id) {
		this.id = id;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}