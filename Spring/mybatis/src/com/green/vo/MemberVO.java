package com.green.vo;

import java.util.Date;

public class MemberVO {
	
	private long id;
	private String email;
	private String name;
	private String password;
	private Date regdate;
	
	public MemberVO() {}

	public MemberVO(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
