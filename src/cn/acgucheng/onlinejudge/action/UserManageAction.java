package cn.acgucheng.onlinejudge.action;

import cn.acgucheng.onlinejudge.entity.Student;
import cn.acgucheng.onlinejudge.entity.Teacher;
import cn.acgucheng.onlinejudge.service.ExamService;
import cn.acgucheng.onlinejudge.service.StudentExamService;
import cn.acgucheng.onlinejudge.service.StudentService;
import cn.acgucheng.onlinejudge.service.TeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class UserManageAction extends ActionSupport{
	
	private String studentID;
	private String teacherID;
	private String username;
	private String name;
	private String password; 
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String deleteStudent(){
		StudentService ss = new StudentService();
		StudentExamService ses = new StudentExamService();
		Student student = ss.findByID(Integer.parseInt(studentID));
		ss.delete(student);
		return "success";
	}
	
	public String addTeacher(){
		TeacherService ts = new TeacherService();
		Teacher teacher = new Teacher(username, name, password);
		ts.insertData(teacher);
		return "success";
	}
	
}
