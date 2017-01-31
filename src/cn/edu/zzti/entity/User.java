package cn.edu.zzti.entity;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private Date loginTime;
	private PersonalInfo personalInfo = null;
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
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public User(String username, String password, Date loginTime) {
		super();
		this.username = username;
		this.password = password;
		this.loginTime = loginTime;
	}
	public User(){
		
	}@Override
	public String toString() {
		return "[username:"+username+",password:"+password+"]";
	}
}
