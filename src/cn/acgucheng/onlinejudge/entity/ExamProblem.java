package cn.acgucheng.onlinejudge.entity;


/**
 * ExamProblem entity. @author MyEclipse Persistence Tools
 */

public class ExamProblem implements java.io.Serializable {

	// Fields

	private ExamProblemId id;
	private Double value;

	// Constructors

	/** default constructor */
	public ExamProblem() {
	}

	/** full constructor */
	public ExamProblem(ExamProblemId id, Double value) {
		this.id = id;
		this.value = value;
	}

	// Property accessors

	public ExamProblemId getId() {
		return this.id;
	}

	public void setId(ExamProblemId id) {
		this.id = id;
	}

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}