package com.math.domain;

public class StudentsVO {
	
	private int t_id;
	private int s_id;
	private String s_name;
	private int s_phone;
	private String s_school;
	private int s_year;
	private int parent_phone;
	private String major;
	
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_phone() {
		return s_phone;
	}
	public void setS_phone(int s_phone) {
		this.s_phone = s_phone;
	}
	public String getS_school() {
		return s_school;
	}
	public void setS_school(String s_school) {
		this.s_school = s_school;
	}
	public int getS_year() {
		return s_year;
	}
	public void setS_year(int s_year) {
		this.s_year = s_year;
	}
	public int getParent_phone() {
		return parent_phone;
	}
	public void setParent_phone(int parent_phone) {
		this.parent_phone = parent_phone;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "StudentVO [s_name=" + s_name + ", s_school=" + s_school + ", s_year=" + s_year + ", major=" + major + "]";
	}
		  

}
