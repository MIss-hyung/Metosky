package com.math.domain;

public class MenuManagerVO {
	private int m_id;
	private int m_code;
	private int m_depth;
	private String m_name;
	private String m_page;
	private int access_type;
	private int is_visible;
	private int is_auth;
	private String lnb_icon;
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getM_code() {
		return m_code;
	}
	public void setM_code(int m_code) {
		this.m_code = m_code;
	}
	public int getM_depth() {
		return m_depth;
	}
	public void setM_depth(int m_depth) {
		this.m_depth = m_depth;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_page() {
		return m_page;
	}
	public void setM_page(String m_page) {
		this.m_page = m_page;
	}
	public int getAccess_type() {
		return access_type;
	}
	public void setAccess_type(int access_type) {
		this.access_type = access_type;
	}
	public int getIs_visible() {
		return is_visible;
	}
	public void setIs_visible(int is_visible) {
		this.is_visible = is_visible;
	}
	public int getIs_auth() {
		return is_auth;
	}
	public void setIs_auth(int is_auth) {
		this.is_auth = is_auth;
	}
	public String getLnb_icon() {
		return lnb_icon;
	}
	public void setLnb_icon(String lnb_icon) {
		this.lnb_icon = lnb_icon;
	}
	
	
}
