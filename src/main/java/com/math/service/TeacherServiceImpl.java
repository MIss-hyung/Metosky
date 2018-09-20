package com.math.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.math.dao.TeachersDAO;
import com.math.domain.TeachersVO;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Inject
	private TeachersDAO dao;

	@Override
	public void insertTeacher(TeachersVO vo) throws Exception {
		dao.insertTeacher(vo);
	}

	@Override
	public int emailExistChk(String t_email) throws Exception {
		return dao.emailExistChk(t_email);
	}

	@Override
	public TeachersVO login(TeachersVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

	@Override
	public List<Map<String, Object>> teachersList(int t_status) throws Exception {
		// TODO Auto-generated method stub
		return dao.teachersList(t_status);
	}

	
}
