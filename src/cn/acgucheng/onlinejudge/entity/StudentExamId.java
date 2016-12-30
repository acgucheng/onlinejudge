package cn.acgucheng.onlinejudge.entity;


/**
 * StudentExamId entity. @author MyEclipse Persistence Tools
 */

public class StudentExamId implements java.io.Serializable {

	// Fields

	private Student student;
	private Exam exam;

	// Constructors

	/** default constructor */
	public StudentExamId() {
	}

	/** full constructor */
	public StudentExamId(Student student, Exam exam) {
		this.student = student;
		this.exam = exam;
	}

	// Property accessors

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudentExamId))
			return false;
		StudentExamId castOther = (StudentExamId) other;

		return ((this.getStudent() == castOther.getStudent()) || (this
				.getStudent() != null && castOther.getStudent() != null && this
				.getStudent().equals(castOther.getStudent())))
				&& ((this.getExam() == castOther.getExam()) || (this.getExam() != null
						&& castOther.getExam() != null && this.getExam()
						.equals(castOther.getExam())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStudent() == null ? 0 : this.getStudent().hashCode());
		result = 37 * result
				+ (getExam() == null ? 0 : this.getExam().hashCode());
		return result;
	}

}