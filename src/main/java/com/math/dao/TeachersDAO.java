package com.math.dao;

import com.math.domain.TeachersVO;

public interface TeachersDAO {
	public void insertTeacher(TeachersVO vo) throws Exception;
	public int emailExistChk(String t_email) throws Exception;
	public TeachersVO login(TeachersVO vo) throws Exception;
}
