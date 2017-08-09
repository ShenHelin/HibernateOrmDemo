package com.company.dao.pojo.twowaym2n.history2;

import java.io.Serializable;

public class Score implements Serializable{
	private static final long serialVersionUID = 1L;
	//联合主键方式实现中间表（Stu--Course）
	private int sid;//Stu--PK
	private int cid;//Course--PK
	private Double courseScore;//分数--中间表私有属性  使用包装类，默认值为null，而不是0
	public Score() {
		// TODO Auto-generated constructor stub
	}
	public Score(int sid, int cid, Double courseScore) {
		super();
		this.sid = sid;
		this.cid = cid;
		this.courseScore = courseScore;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Double getCourseScore() {
		return courseScore;
	}
	public void setCourseScore(Double courseScore) {
		this.courseScore = courseScore;
	}
	@Override
	public String toString() {
		return "Score [sid=" + sid + ", cid=" + cid + ", courseScore=" + courseScore + "]";
	}
	
	
	
}
