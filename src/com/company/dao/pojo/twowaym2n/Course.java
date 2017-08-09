package com.company.dao.pojo.twowaym2n;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private int cid;
	private String courseName;
	private Set<Score> scores = new HashSet<Score>();
	
	public Set<Score> getScores() {
		return scores;
	}
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
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

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", courseName=" + courseName + ", stus=" + "]";
	}
	
	
}
