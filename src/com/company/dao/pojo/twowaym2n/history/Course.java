package com.company.dao.pojo.twowaym2n.history;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private int cid;
	private String courseName;
	private Set<Stu> stus = new HashSet<Stu>();
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Set<Stu> getStus() {
		return stus;
	}
	public void setStus(Set<Stu> stus) {
		this.stus = stus;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", courseName=" + courseName + ", stus=" + stus.size() + "]";
	}
	
	
}
