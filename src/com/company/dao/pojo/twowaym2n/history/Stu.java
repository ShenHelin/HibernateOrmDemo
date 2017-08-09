package com.company.dao.pojo.twowaym2n.history;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Stu implements Serializable{
	private static final long serialVersionUID = 1L;
	private int sid;
	private String stuName;
	private Set<Course> courses = new HashSet<Course>();// ¶à¶Ô¶à

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Stu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Stu [sid=" + sid + ", stuName=" + stuName + ", courses=" + courses.size() + "]";
	}

	public Stu(String stuName) {
		super();
		this.stuName = stuName;
	}

}
