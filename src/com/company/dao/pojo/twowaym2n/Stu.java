package com.company.dao.pojo.twowaym2n;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Stu implements Serializable{
	private static final long serialVersionUID = 1L;
	private int sid;
	private String stuName;
	private Set<Score> scores = new HashSet<Score>();

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

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

	
	public Stu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Stu [sid=" + sid + ", stuName=" + stuName +  "]";
	}

	public Stu(String stuName) {
		super();
		this.stuName = stuName;
	}

}
