package com.company.dao.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int userid;//Hibernate配置时，使其成为自增主键auto_increment
	private String username;
	private String password;
	private Date Regtime;//当使用Hibernate时，使用java.util.Date作为时间属性的数据类型
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, Date regtime) {
		super();
		this.username = username;
		this.password = password;
		Regtime = regtime;
	}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegtime() {
		return Regtime;
	}
	public void setRegtime(Date regtime) {
		Regtime = regtime;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", Regtime=" + Regtime
				+ "]";
	}
	
}
