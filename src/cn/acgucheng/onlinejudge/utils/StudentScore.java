package cn.acgucheng.onlinejudge.utils;

import cn.acgucheng.onlinejudge.entity.Student;
import cn.acgucheng.onlinejudge.entity.StudentExam;
import cn.acgucheng.onlinejudge.service.StudentService;

public class StudentScore {
	private Double score;
	private Student student;
	
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentScore(StudentExam se) {
		// TODO Auto-generated constructor stub
		score = se.getScore();
		StudentService ss = new StudentService();
		student = ss.findByID(se.getId().getStudent().getId());
	}
}
