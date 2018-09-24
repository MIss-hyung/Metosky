package com.math.service;

import java.util.List;
import java.util.Map;

import com.math.domain.TeachersVO;

public interface TeacherService {
	public void insertTeacher(TeachersVO vo) throws Exception;
	public int emailExistChk(String t_email) throws Exception;
	public TeachersVO login(TeachersVO vo) throws Exception;
	public List<Map<String,Object>> teachersList(int t_status) throws Exception;
	public void approveTeacher(TeachersVO vo) throws Exception;
}
