package com.math.domain;

public class TeachersVO {
	
	private String t_name;
	private String created;
	private String t_email;
	private String t_pswd;
	private int is_admin;
	private int t_status;

	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getT_email() {
		return t_email;
	}
	public void setT_email(String t_email) {
		this.t_email = t_email;
	}
	public String getT_pswd() {
		return t_pswd;
	}
	public void setT_pswd(String t_pswd) {
		this.t_pswd = t_pswd;
	}
	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
	public int getIs_admin() {
		return is_admin;
	}
	public void setT_status(int t_status) {
		this.t_status = t_status;
	}
	public int getT_status() {
		return t_status;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "TeachersVO [t_name=" + t_name + ", t_email=" + t_email + ", t_pswd=" + t_pswd + "]";
	}
		  

}
