package cn.acgucheng.onlinejudge.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String name;
	private String class_;
	private String password;
	private Set studentExams = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String username, String name, String class_, String password) {
		this.username = username;
		this.name = name;
		this.class_ = class_;
		this.password = password;
	}

	/** full constructor */
	public Student(String username, String name, String class_,
			String password, Set studentExams) {
		this.username = username;
		this.name = name;
		this.class_ = class_;
		this.password = password;
		this.studentExams = studentExams;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getStudentExams() {
		return this.studentExams;
	}

	public void setStudentExams(Set studentExams) {
		this.studentExams = studentExams;
	}

}