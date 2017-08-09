package com.company.dao.pojo.twoway121;

import java.io.Serializable;
import java.util.Date;

public class Detail implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String realname;
	private double balance;
	private Date regtime;// 日期+时间
	private Login login;// 121

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Detail() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public Detail(String realname, double balance, Date regtime) {
		super();
		this.realname = realname;
		this.balance = balance;
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		return "Detail [id=" + id + ", realname=" + realname + ", balance=" + balance + ", regtime=" + regtime + "]";
	}

}
