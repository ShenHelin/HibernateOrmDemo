package com.company.dao.pojo.selftest;

import java.io.Serializable;

public class Score implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//主键自增
	private Stu stu;//外键关联
	private Course course;//外键关联
	private Double courseScore;//分数--中间表私有属性  使用包装类，默认值为null，而不是0
	
	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(Stu stu, Course course) {
		super();
		this.stu = stu;
		this.course = course;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Stu getStu() {
		return stu;
	}

	public void setStu(Stu stu) {
		this.stu = stu;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Double getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(Double courseScore) {
		this.courseScore = courseScore;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", stu=" + stu + ", course=" + course + ", courseScore=" + courseScore + "]";
	}
	
	
	
	
}
