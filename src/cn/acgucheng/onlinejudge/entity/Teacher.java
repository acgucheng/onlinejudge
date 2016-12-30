package cn.acgucheng.onlinejudge.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String name;
	private String password;
	private Set exams = new HashSet(0);
	private Set problems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String username, String name, String password) {
		this.username = username;
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public Teacher(String username, String name, String password, Set exams,
			Set problems) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.exams = exams;
		this.problems = problems;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getExams() {
		return this.exams;
	}

	public void setExams(Set exams) {
		this.exams = exams;
	}

	public Set getProblems() {
		return this.problems;
	}

	public void setProblems(Set problems) {
		this.problems = problems;
	}

}