package com.math.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.math.dao.StudentsDAO;
import com.math.domain.StudentsVO;

@Service
public class StudentListServicelmp implements StudentListService {
	
	@Inject
	private StudentsDAO StudentsDAO;

	@Override
	public List<Map<String, Object>> StudentsList(int t_id) throws Exception {
		// TODO Auto-generated method stub
		return StudentsDAO.studentsList(t_id);
	}
	
	@Override
	public List<Map<String, Object>> AdminstudentsList() throws Exception {
		// TODO Auto-generated method stub
		return StudentsDAO.AdminstudentsList();
	}

}


