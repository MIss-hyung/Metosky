package com.math.service;

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

	
}
