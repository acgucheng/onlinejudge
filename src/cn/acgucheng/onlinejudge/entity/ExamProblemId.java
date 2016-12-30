package cn.acgucheng.onlinejudge.entity;


/**
 * ExamProblemId entity. @author MyEclipse Persistence Tools
 */

public class ExamProblemId implements java.io.Serializable {

	// Fields

	private Exam exam;
	private Problem problem;

	// Constructors

	/** default constructor */
	public ExamProblemId() {
	}

	/** full constructor */
	public ExamProblemId(Exam exam, Problem problem) {
		this.exam = exam;
		this.problem = problem;
	}

	// Property accessors

	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Problem getProblem() {
		return this.problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ExamProblemId))
			return false;
		ExamProblemId castOther = (ExamProblemId) other;

		return ((this.getExam() == castOther.getExam()) || (this.getExam() != null
				&& castOther.getExam() != null && this.getExam().equals(
				castOther.getExam())))
				&& ((this.getProblem() == castOther.getProblem()) || (this
						.getProblem() != null && castOther.getProblem() != null && this
						.getProblem().equals(castOther.getProblem())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getExam() == null ? 0 : this.getExam().hashCode());
		result = 37 * result
				+ (getProblem() == null ? 0 : this.getProblem().hashCode());
		return result;
	}

}